import { Component, OnInit } from '@angular/core';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {FormControl} from '@angular/forms';
import {Observable, Subject} from 'rxjs';
import {State} from '../../model/State';
import {debounceTime, distinctUntilChanged, map, startWith, switchMap} from 'rxjs/operators';
import {Adresse} from '../../model/Adresse';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  private searchTerms = new Subject<string>();

  adressResults: Array<Feature>;


  constructor(private adresseService: AdresseApiService) {
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  ngOnInit(): void {
      this.searchTerms.pipe(
      debounceTime(1000),
      distinctUntilChanged(),
      switchMap((term: string) => this.adresseService.adresseSearch(term)),
    ).subscribe((res) => this.adressResults = res.features);
  }

  getAdresses() {



  }

}
