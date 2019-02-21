import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Adresse} from '../../model/Adresse';
import {Observable} from 'rxjs';
const baseUrl = 'https://api-adresse.data.gouv.fr/search/?q=';
const httpOptions = {
  headers: new HttpHeaders({
    'Accept': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})



export class AdresseApiService {

  constructor(private http: HttpClient) { }

  adresseSearch(term: string) {
    return this.http.get<AdresseJson>(baseUrl + term);
  }
}
