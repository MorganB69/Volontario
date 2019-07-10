import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';
import {Mission} from '../../model/Mission';
import {Association} from '../../model/Association';
import {Benevole} from '../../model/Benevole';
import {Inscription} from '../../model/Inscription';
import {InscriptionDTO} from '../../model/dto/InscriptionDTO';
import {InscriptAssoDTO} from '../../model/dto/InscriptAssoDTO';
import {InscriptBeneDTO} from '../../model/dto/InscriptBeneDTO';

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
inscriptionAsso(association: InscriptAssoDTO) {
    console.log(association);
    return this.http.post<Association>(this.baseUrl + 'association/inscription', association, {headers: headers});
}

// Appel WS : Inscription bénévole
inscriptionBene(benevole: InscriptBeneDTO) {
    console.log(benevole);
    return this.http.post<Benevole>(this.baseUrl + 'benevole/inscription', benevole, {headers: headers});
  }
// Obtenir une mission par son id
  getMissionById(id: string): Observable<Mission> {
    const params = new HttpParams().set('id', id);
    return this.http.get<Mission>(this.baseUrl + 'mission/id', {headers: headers, params: params});
}

// Rajout d'un utilisateur à une mission
  addUserToMission(idInscription: number) {
    return this.http.post(this.baseUrl + 'mission/addUser', idInscription, {headers: headers} );
  }

  // Suppression d'un utilisateur à une mission
  deleteUserFromMission (idInscription: number) {
    return this.http.post(this.baseUrl + 'mission/deleteUser', idInscription, {headers: headers} );
  }

  // Obtention d'une association
  getAssociation(idAssociation: string) {
    const params = new HttpParams().set('idAssociation', idAssociation);
    return this.http.get<Association>(this.baseUrl + 'association/idAssociation', {headers: headers, params: params});
  }
  // Sauvegarde d'une association
  saveAssociation(association: Association) {
    return this.http.post<Association>(this.baseUrl + 'association', association, {headers: headers});
  }

  // Obtention des missions par association
  getMissionsByAssociation(idAssociation: string) {
    return this.http.get<Array<Mission>>(this.baseUrl + 'association/' + idAssociation + '/missions', {headers: headers} );
  }

  // Sauvegarde d'une mission
  saveMission(mission: Mission, idAssociation: string) {
    return this.http.post<Mission>(this.baseUrl + 'association/' + idAssociation + '/mission', mission, {headers: headers});
  }

  // Obtention des missions par association
  getInscriptionsByMission(idMission: string) {
    return this.http.get<Array<InscriptionDTO>>(this.baseUrl + 'mission/' + idMission + '/inscriptions', {headers: headers} );
  }

  // Sauvegarde d'une inscription
  saveInscription(idMission: string, inscription: Inscription) {
    return this.http.post<Inscription>(this.baseUrl + 'mission/' + idMission + '/inscription', inscription, {headers: headers} );
  }

  // delete d'une inscription
  deleteInscription(idInscription: number) {
     const params = new HttpParams().set('idInscription', idInscription.toString());
     return this.http.delete<Boolean>(this.baseUrl + 'inscription/', {headers: headers, params: params} );
  }

}
