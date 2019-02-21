import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';
import {Mission} from '../../model/Mission';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RestService {

  baseUrl = environment.baseUrl;



  constructor(private http: HttpClient) { }



getDomaines(): Observable<Array<Domaine>> {
  return this.http.get<Domaine[]>(this.baseUrl + 'mission/domaines');
}

recherche(recherche: Recherche) {
    console.log(recherche);
    return this.http.post<Mission[]>(this.baseUrl + 'mission/recherche', recherche, httpOptions );

}

}
