import { Injectable } from '@angular/core';
import {RestService} from '../rest/rest.service';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';
import {UploadService} from '../upload/upload.service';

@Injectable({
  providedIn: 'root'
})
export class MissionService {



  constructor(private restService: RestService, private uploadService: UploadService) { }


  getDomaines() {
  return this.restService.getDomaines();
  }

  getDetpartements() {
    return this.restService.getDepartements();
  }

  getCommunes(dep: string) {
    return this.restService.getCommunes(dep);
  }

  rechercheMission(recherche: Recherche) {
    return this.restService.recherche(recherche);
  }

  getImage(path: string) {
  return this.uploadService.getImage(path);
  }

  getMissionById(id: string) {
    return this.restService.getMissionById(id);
  }

  addUserToMission(idInscription: number) {
    return this.restService.addUserToMission(idInscription);
  }

  deleteUserToMission(idInscription: number) {
   return this.restService.deleteUserFromMission(idInscription);
  }

}
