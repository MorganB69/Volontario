import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AssociationService} from '../../services/association/association.service';
import {Domaine} from '../../model/Domaine';
import {Mission} from '../../model/Mission';
import {User} from '../../model/User';
import {ActivatedRoute, Router} from '@angular/router';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';
import {debounceTime, distinctUntilChanged, filter, switchMap} from 'rxjs/operators';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {Subject} from 'rxjs';
import {Adresse} from '../../model/Adresse';
import {element} from 'protractor';


@Component({
  selector: 'app-espace-mission',
  templateUrl: './espace-mission.component.html',
  styleUrls: ['./espace-mission.component.css']
})
export class EspaceMissionComponent implements OnInit {

  missions: Array<Mission>;
  idAssociation: string;
  user: User;
  newmission: Mission = new Mission();
  domaines: Array<Domaine> = new Array<Domaine>();
  searchTerms = new Subject<string>();
  adressResults: Array<Feature>;
  featureAdresse: Feature;
  adresse: Adresse = new Adresse();
  adresseError = false;
  isEdit = false;

  constructor(private assoService: AssociationService,
              private adresseService: AdresseApiService,
              private route: ActivatedRoute,
              private missionService: MissionService,
              private authService: UserService,
              private router: Router) {
  }

  ngOnInit() {
    this.getDomaines();
    this.getUser();
    this.getAdresses();
  }

  searchAdresse(term: string): void {
    if (term) {
      this.searchTerms.next(term);
    }
  }

  getAdresses() {
    this.searchTerms.pipe(
      filter(term => term != null && term !== ''),
      debounceTime(1000),
      distinctUntilChanged(),
      switchMap((term: string) => this.adresseService.adresseSearch(term)),
    ).subscribe((res) => {
      this.adressResults = res.features;
      console.log(this.adressResults);
    });
  }

  onSelectionChanged(feature: Feature) {
    this.featureAdresse = feature;
    console.log(this.featureAdresse);
  }


  getUser() {
    this.authService.getUser().subscribe(res => {
        if (res) {
          this.user = res;
          this.idAssociation = String(this.user.association.idAssociation);
          this.getMissionsByAsso();
        }
      }
    );
  }

  getMissionsByAsso() {
    this.assoService.getMissionsByAsso(this.idAssociation).subscribe(
      res => {
        this.missions = res;
        console.log(this.missions);
      }
    );
  }

  saveMission() {
    if (!this.isEdit) {
      if (!this.featureAdresse) {
        this.adresseError = true;
      } else {
        this.adresse.jsonToAdresse(this.featureAdresse);
        this.newmission.adresse = this.adresse;
      }
    }
    this.missionService.saveMission(this.newmission, this.idAssociation).subscribe(res => {
      if (res) {
        this.reset();
        this.getMissionsByAsso();
      }
    });
  }

  edit(mission: Mission) {
    this.isEdit = true;
    this.newmission = mission;
    if (this.newmission) {
      for (const domaineAsso of this.domaines) {
        if (this.newmission.domaine.idDomaine === domaineAsso.idDomaine) {
          this.newmission.domaine = domaineAsso;
        }
      }
    }
  }


  getDomaines() {
    this.missionService.getDomaines().subscribe(
      (response) => this.domaines = response,
      (error) => console.log('error domaine'));
    return this.domaines;
  }

  reset() {
    this.isEdit = false;
    this.newmission = new Mission();
    this.searchTerms = new Subject<string>();
    this.adresse = new Adresse();
    this.adresseError = false;
  }


}
