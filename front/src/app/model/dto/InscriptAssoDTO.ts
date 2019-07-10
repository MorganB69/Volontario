import {Association} from '../Association';


export class InscriptAssoDTO {
  association: Association = new Association();
  identifiant: string;
  mdp: string;
  mail: string;
  role: string;

  constructor() {
  }

}
