import {Injectable} from '@angular/core';
import {RestService} from '../rest/rest.service';
import {Association} from '../../model/Association';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  constructor(private rest: RestService) {
  }

  getAssociation (idAssociation: string) {
    return this.rest.getAssociation(idAssociation);
  }
  saveAssociation(association: Association) {
    return this.rest.saveAssociation(association);
  }
  getMissionsByAsso(idAssociation: string) {
    return this.rest.getMissionsByAssociation(idAssociation);
  }
}
