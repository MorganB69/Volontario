import {Inscription} from '../Inscription';
import {BenevoleDTO} from './BenevoleDTO';

export class InscriptionDTO {
  inscription: Inscription;
  benevole: Array<BenevoleDTO>;
  nbInscription: number;

  constructor() {
  }

}
