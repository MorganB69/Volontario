import {Association} from './Association';
import {Benevole} from './Benevole';

export class User {
  user_id: number;
  identifiant: string;
  mdp: string;
  mail: string;
  role: string;
  association: Association;
  benevole: Benevole;
  token: string;
}
