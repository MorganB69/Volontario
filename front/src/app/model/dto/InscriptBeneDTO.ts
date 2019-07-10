import {Benevole} from '../Benevole';

export class InscriptBeneDTO {
  benevole: Benevole = new Benevole();
  identifiant: string;
  mdp: string;
  mail: string;
  role: string;

  constructor() {
  }

}
