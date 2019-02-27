import {Adresse} from './Adresse';
import {Domaine} from './Domaine';
import {Mission} from './Mission';

export class Association {
  id: number;
  nom: string;
  mail: string;
  web: string;
  identifiant: string;
  mdp: string;
  siret: string;
  description: string;
  photo: string;
  adresse: Adresse;
  missions: Array<Mission>;
  domaines: Array<Domaine>;

  constructor() {
  }

}
