import {Injectable} from '@angular/core';
import {RestService} from '../rest/rest.service';
import {Domaine} from '../../model/Domaine';
import {Recherche} from '../../model/Recherche';
import {UploadService} from '../upload/upload.service';
import {Mission} from '../../model/Mission';
import {Inscription} from '../../model/Inscription';

@Injectable({
  providedIn: 'root'
})
export class MissionService {


  constructor(private restService: RestService, private uploadService: UploadService) {
  }


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

  saveMission(mission: Mission, idAssociation: string) {
    return this.restService.saveMission(mission, idAssociation);
  }

  getInscriptionsByIdMission(idMission: string) {
    return this.restService.getInscriptionsByMission(idMission);
  }

  saveInscription(idMission: string, inscription: Inscription) {
    return this.restService.saveInscription(idMission, inscription);
  }

  deleteInscription(idInscription: string) {
    return this.restService.deleteInscription(idInscription);
  }

}
