import {Component, Input, OnInit} from '@angular/core';
import {AdresseApiService} from '../../services/api/adresse-api.service';
import {FormControl} from '@angular/forms';
import {Observable, Subject} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter, map, startWith, switchMap} from 'rxjs/operators';
import {Adresse} from '../../model/Adresse';
import {SiretService} from '../../services/api/siret.service';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  private searchTerms = new Subject<string>();
  private adressResults: Array<Feature>;
  private featureAdresse: Feature;

  @Input()
  private denomination: String;
  private adresse: Adresse = new Adresse();


  constructor(private siretService: SiretService) {
  }



  ngOnInit(): void {
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  getInfos() {



  }

  refresh(term: string) {
    this.siretService.getInfos(term).subscribe((res) => this.denomination = res.records[0].fields.l1_normalisee);
  }



}
