import {Adresse} from './Adresse';
import {Inscription} from './Inscription';

export class Benevole {
  id: number;
  identifiant: string;
  nom: string;
  prenom: string;
  mail: string;
  date_naissance: Date;
  adresse: Adresse;
  inscriptions: Array<Inscription>;


  constructor() {
  }

}
