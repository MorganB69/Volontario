import { Injectable } from '@angular/core';
import {RestService} from '../rest/rest.service';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';

@Injectable({
  providedIn: 'root'
})
export class MissionService {


  constructor(private restService: RestService) { }


  getDomaines() {
  return this.restService.getDomaines();
  }

  rechercheMission(recherche: Recherche) {
    return this.restService.recherche(recherche);
  }

}
