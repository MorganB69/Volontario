import {Association} from './Association';
import {Mission} from './Mission';

export class Domaine {
  idDomaine: number;
  nom: string;
  description: string;
  associations: Array<Association>;
  pmissions: Array<Mission>;


  constructor() {
  }


}
