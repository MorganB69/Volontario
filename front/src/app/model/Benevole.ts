import {Adresse} from './Adresse';
import {Inscription} from './Inscription';

export class Benevole {
  private _id: number;
  private _identifiant: string;
  private _nom: string;
  private _prenom: string;
  private _mail: string;
  private _date_naissance: Date;
  private _adresse: Adresse;
  private _inscriptions: Array<Inscription>;


  constructor() {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get identifiant(): string {
    return this._identifiant;
  }

  set identifiant(value: string) {
    this._identifiant = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get mail(): string {
    return this._mail;
  }

  set mail(value: string) {
    this._mail = value;
  }

  get date_naissance(): Date {
    return this._date_naissance;
  }

  set date_naissance(value: Date) {
    this._date_naissance = value;
  }

  get adresse(): Adresse {
    return this._adresse;
  }

  set adresse(value: Adresse) {
    this._adresse = value;
  }

  get inscriptions(): Array<Inscription> {
    return this._inscriptions;
  }

  set inscriptions(value: Array<Inscription>) {
    this._inscriptions = value;
  }
}
