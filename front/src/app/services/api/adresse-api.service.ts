import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
const baseUrl = 'https://api-adresse.data.gouv.fr/search/?q=';


@Injectable({
  providedIn: 'root'
})



export class AdresseApiService {

  httpOptions = {
    headers: new HttpHeaders(
      {
        'Accept': 'application/json',
        'skip' : 'undefined',
      }
    )
  };

  constructor(private http: HttpClient) { }

  adresseSearch(term: string) {
    return this.http.get<AdresseJson>(baseUrl + term, this.httpOptions);
  }
}
