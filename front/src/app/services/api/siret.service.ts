import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Token} from '../../model/Token';
import {Siret} from '../../model/Siret';


const searchUrl = 'https://data.opendatasoft.com/api/records/1.0/search?dataset=sirene@public&refine.siret=';


@Injectable({
  providedIn: 'root'
})
export class SiretService {


  httpOptions = {
    headers: new HttpHeaders(
      {
        'Accept': 'application/json',
      }
    )
  };




  constructor(private http: HttpClient) {

  }



getInfos(siret: string) {
  return this.http.get<Siret>(searchUrl + siret, this.httpOptions);
}

}
