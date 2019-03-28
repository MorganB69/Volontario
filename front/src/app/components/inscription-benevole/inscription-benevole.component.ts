import { Component, OnInit } from '@angular/core';
import {Subject} from 'rxjs';
import {Adresse} from '../../model/Adresse';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {debounceTime, distinctUntilChanged, filter, switchMap} from 'rxjs/operators';
import {User} from '../../model/User';
import {Benevole} from '../../model/Benevole';
import {RestService} from '../../services/rest/rest.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ModalErrorComponent} from '../../modal-error/modal-error.component';

@Component({
  selector: 'app-inscription-benevole',
  templateUrl: './inscription-benevole.component.html',
  styleUrls: ['./inscription-benevole.component.css']
})
export class InscriptionBenevoleComponent implements OnInit {

  searchTerms = new Subject<string>();
   adressResults: Array<Feature>;
  featureAdresse: Feature;
  adresse: Adresse = new Adresse();
   user: User = new User();
   benevole: Benevole = new Benevole();
   adresseError = false;



  constructor(private adresseService: AdresseApiService,
              private restService: RestService,
              private router: Router,
              private modal: NgbModal) {
  }



  ngOnInit(): void {
    this.getAdresses();
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

  onSubmit() {
    if (!this.featureAdresse) {
      this.adresseError = true;
    } else {
      this.adresse.jsonToAdresse(this.featureAdresse);
      this.benevole.adresse = this.adresse;
      this.user.role = 'BENE';
      this.benevole.user = this.user;
      this.restService.inscriptionBene(this.benevole).subscribe();
      const modalRef = this.modal.open(ModalErrorComponent);
      modalRef.componentInstance.body = 'Vous allez être redirigé vers la page de Login';
      modalRef.componentInstance.titre = 'Félicitation pour votre inscription';
      this.router.navigate(['login']);
    }
  }
  onSelectionChanged(feature: Feature) {
    this.featureAdresse = feature;
  }

}
