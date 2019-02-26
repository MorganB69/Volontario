import { Component, OnInit } from '@angular/core';
import {Subject} from 'rxjs';
import {Adresse} from '../../model/Adresse';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {debounceTime, distinctUntilChanged, filter, switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-inscription-benevole',
  templateUrl: './inscription-benevole.component.html',
  styleUrls: ['./inscription-benevole.component.css']
})
export class InscriptionBenevoleComponent implements OnInit {

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
    console.log(this.adresse);
  }
  onSelectionChanged(feature: Feature) {
    this.featureAdresse = feature;
  }

}
