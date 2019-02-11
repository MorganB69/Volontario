import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Token} from '../../model/Token';

const tokenUrl = 'https://api.insee.fr/token?grant_type=client_credentials';
const credentials = environment.credential;
const httpOptionsGetToken = {
  headers: new HttpHeaders({
    'Authorization': 'Basic' + credentials})
};
const searchUrl = 'https://api.insee.fr/entreprises/sirene/V3/siret/';


@Injectable({
  providedIn: 'root'
})
export class SiretService implements OnInit {
  token: string;

  httpOptions = {
    headers: new HttpHeaders(
      {
        'Accept': 'application/json',
        'Authorization': 'Bearer' + ' ' + this.token
      }
    )
  };

  ngOnInit(): void {
    this.getToken();
  }


  constructor(private http: HttpClient) { }


getToken() {
  return this.http.post<Token>(tokenUrl, httpOptionsGetToken).subscribe(
    (res) => this.token = res.access_token );
}

getInfos(siret: string) {
  return this.http.get(searchUrl + siret);
}

}
