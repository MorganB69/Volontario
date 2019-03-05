import {Adresse} from './Adresse';
import {Domaine} from './Domaine';
import {Mission} from './Mission';
import {User} from './User';

export class Association {
  id: number;
  nom: string;
  web: string;
  siret: string;
  description: string;
  photo: string;
  adresse: Adresse;
  missions: Array<Mission>;
  domaines: Array<Domaine>;
  users: Array<User> = new Array<User>();

  constructor() {
  }

}
