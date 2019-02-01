import {Adresse} from './Adresse';
import {Domaine} from './Domaine';
import {Mission} from './Mission';

export class Association {
  private _id: number;
  private _nom: string;
  private _mail: string;
  private _web: string;
  private _identifiant: string;
  private _mdp: string;
  private _siret: string;
  private _description: string;
  private _photo: string;
  private _adresse: Adresse;
  private _missions: Array<Mission>;
  private _domaines: Array<Domaine>;

  constructor() {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get mail(): string {
    return this._mail;
  }

  set mail(value: string) {
    this._mail = value;
  }

  get web(): string {
    return this._web;
  }

  set web(value: string) {
    this._web = value;
  }

  get identifiant(): string {
    return this._identifiant;
  }

  set identifiant(value: string) {
    this._identifiant = value;
  }

  get mdp(): string {
    return this._mdp;
  }

  set mdp(value: string) {
    this._mdp = value;
  }

  get siret(): string {
    return this._siret;
  }

  set siret(value: string) {
    this._siret = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get photo(): string {
    return this._photo;
  }

  set photo(value: string) {
    this._photo = value;
  }

  get adresse(): Adresse {
    return this._adresse;
  }

  set adresse(value: Adresse) {
    this._adresse = value;
  }

  get missions(): Array<Mission> {
    return this._missions;
  }

  set missions(value: Array<Mission>) {
    this._missions = value;
  }

  get domaines(): Array<Domaine> {
    return this._domaines;
  }

  set domaines(value: Array<Domaine>) {
    this._domaines = value;
  }
}
