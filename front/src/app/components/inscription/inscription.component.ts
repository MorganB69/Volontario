import {Component, Input, OnInit} from '@angular/core';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {FormControl} from '@angular/forms';
import {Observable, Subject} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, map, startWith, switchMap} from 'rxjs/operators';
import {Adresse} from '../../model/Adresse';
import {SiretService} from '../../services/api/siret.service';
import {Association} from '../../model/Association';
import {MissionService} from '../../services/mission/mission.service';
import {Domaine} from '../../model/Domaine';
import {UploadService} from '../../services/upload/upload.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {RestService} from '../../services/rest/rest.service';
import {User} from '../../model/User';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  private searchTerms = new Subject<string>();
  private adressResults: Array<Feature>;
  private featureAdresse: Feature;
  private adresse: Adresse = new Adresse();
  private user: User = new User();
  @Input()
   association: Association = new Association();
  @Input()
   denomination: string;
  searchBoxAdress: string;
  domaines: Array<Domaine> = new Array<Domaine>();
  private siretError = false;
  private siretValid = false;



  constructor(private siretService: SiretService,
              private adresseService: AdresseApiService,
              private missionService: MissionService,
              private uploadService: UploadService,
              private restService: RestService) {
  }



  ngOnInit(): void {
    this.getAdresses();
    this.getDomaines();
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  getAdresses() {
    this.searchTerms.pipe(
      filter(term => term != null && term !== ''),
      debounceTime(1000),
      distinctUntilChanged(),
      switchMap((term: string) => this.adresseService.adresseSearch(term)),
    ).subscribe((res) => this.adressResults = res.features);


  }
  onSelectionChanged(feature: Feature) {
    this.featureAdresse = feature;
  }

  refresh(term: string) {
    this.siretService.getInfos(term)
    .subscribe((res) => {
      if (res.records.length !== 0) {
        this.siretValid = true,
        this.association.nom = res.records[0].fields.l1_normalisee,
          this.searchBoxAdress = (res.records[0].fields.l4_declaree + ' ' + res.records[0].fields.l6_declaree),
          this.adresseService.adresseSearch(res.records[0].fields.l4_declaree + ' ' + res.records[0].fields.l6_declaree).subscribe(
            (resu) => this.featureAdresse = resu.features[0]
          ); } else {this.siretError = true; }
    });
  }


  reset() {
    this.association.siret = null;
    this.association.nom = null;
    this.searchBoxAdress = null;
    this.featureAdresse = null;
    this.siretValid = false;
  }


  getDomaines() {
    this.missionService.getDomaines().subscribe(
      (response) => this.domaines = response,
      (error) => console.log('error domaine'));
    return this.domaines;
  }

  selectFile(event) {
    const file = event.target.files.item(0);

    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      alert('invalid format!');
    }
  }

  onSubmit() {
    if (this.selectedFiles) {
      this.currentFileUpload = this.selectedFiles.item(0);
      this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe();
      this.association.photo = this.selectedFiles.item(0).name;
      this.selectedFiles = undefined;
    }
    this.adresse.jsonToAdresse(this.featureAdresse);
    this.association.adresse = this.adresse;
    this.user.role = 'Association';
    this.association.users.push(this.user);
    this.restService.inscriptionAsso(this.association).subscribe();
  }
}
