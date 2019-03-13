import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';
import {Mission} from '../../model/Mission';
import {Association} from '../../model/Association';
import {Benevole} from '../../model/Benevole';

const headers = new HttpHeaders().set('Content-Type', 'application/json');

@Injectable({
  providedIn: 'root'
})
export class RestService {

  baseUrl = environment.baseUrl;



  constructor(private http: HttpClient) { }


// Appel WS : Obtention des domaines
getDomaines(): Observable<Array<Domaine>> {
  return this.http.get<Domaine[]>(this.baseUrl + 'mission/domaines');
}

// Appel WS : Obtention des départements
  getDepartements(): Observable<Array<string>> {
    return this.http.get<string[]>(this.baseUrl + 'mission/departements');
  }

  getCommunes(dep: string): Observable<Array<string>> {
    return this.http.post<string[]>(this.baseUrl + 'mission/communes', dep);
  }

// Appel WS : Obtention des missions en fonction de l'objet recherche
recherche(recherche: Recherche) {
    console.log(recherche);
    return this.http.post<Mission[]>(this.baseUrl + 'mission/recherche', recherche, {headers: headers} );

}

// Appel WS : Inscription d'une association
inscriptionAsso(association: Association) {
    console.log(association);
    return this.http.post<Association>(this.baseUrl + 'association/inscription', association, {headers: headers});
}

// Appel WS : Inscription bénévole
inscriptionBene(benevole: Benevole) {
    console.log(benevole);
    return this.http.post<Benevole>(this.baseUrl + 'benevole/inscription', benevole, {headers: headers});
  }

  getMissionById(id: string): Observable<Mission> {
    const params = new HttpParams().set('id', id);
    return this.http.get<Mission>(this.baseUrl + 'mission/id', {headers: headers, params: params});
}

}
