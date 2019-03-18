import {Association} from './Association';
import {Adresse} from './Adresse';
import {Domaine} from './Domaine';
import {Inscription} from './Inscription';

export class Mission {
  idMission: number;
  nom: string;
  description: string;
  complement: string;
  competence: string;
  association: Association;
  adresse: Adresse;
  domaine: Domaine;
  inscriptions: Array<Inscription>;


  constructor() {
  }

}
