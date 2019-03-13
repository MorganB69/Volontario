import {Timestamp} from 'rxjs';
import {Mission} from './Mission';
import {Benevole} from './Benevole';

export class Inscription {
  idInscription: number;
  nbplaces: number;
  debut: Date;
  fin: Date;
  mission: Mission;
  benevoles: Array<Benevole>;


  constructor() {
  }

}
