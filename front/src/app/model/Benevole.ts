import {Adresse} from './Adresse';
import {Inscription} from './Inscription';
import {User} from './User';

export class Benevole {
  id: number;
  nom: string;
  prenom: string;
  adresse: Adresse;
  inscriptions: Array<Inscription>;
  user: User;


  constructor() {
  }

}
