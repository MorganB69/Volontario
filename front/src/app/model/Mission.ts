import {Association} from './Association';
import {Adresse} from './Adresse';
import {Domaine} from './Domaine';
import {Inscription} from './Inscription';

export class Mission {
  private _idMission: number;
  private _nom: string;
  private _description: string;
  private _complement: string;
  private _competence: string;
  private _association: Association;
  private _adresse: Adresse;
  private _domaine: Domaine;
  private _inscriptions: Array<Inscription>;


  constructor() {
  }

  get idMission(): number {
    return this._idMission;
  }

  set idMission(value: number) {
    this._idMission = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get complement(): string {
    return this._complement;
  }

  set complement(value: string) {
    this._complement = value;
  }

  get competence(): string {
    return this._competence;
  }

  set competence(value: string) {
    this._competence = value;
  }

  get association(): Association {
    return this._association;
  }

  set association(value: Association) {
    this._association = value;
  }

  get adresse(): Adresse {
    return this._adresse;
  }

  set adresse(value: Adresse) {
    this._adresse = value;
  }

  get domaine(): Domaine {
    return this._domaine;
  }

  set domaine(value: Domaine) {
    this._domaine = value;
  }

  get inscriptions(): Array<Inscription> {
    return this._inscriptions;
  }

  set inscriptions(value: Array<Inscription>) {
    this._inscriptions = value;
  }
}
