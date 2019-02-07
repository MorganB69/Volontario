import { Component, OnInit } from '@angular/core';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {FormControl} from '@angular/forms';
import {Observable, Subject} from 'rxjs';
import {State} from '../../model/State';
import {debounceTime, distinctUntilChanged, filter, map, startWith, switchMap} from 'rxjs/operators';
import {Adresse} from '../../model/Adresse';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  private searchTerms = new Subject<string>();
  private adressResults: Array<Feature>;
  private featureAdresse: Feature;
  private adresse: Adresse = new Adresse();


  constructor(private adresseService: AdresseApiService) {
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
    this.adresse.jsonToAdresse(this.featureAdresse);
  }
  onSelectionChanged(feature: Feature) {
    this.featureAdresse = feature;
  }


}
