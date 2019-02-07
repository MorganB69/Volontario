import {Benevole} from './Benevole';
import {Mission} from './Mission';
import {Association} from './Association';

export class Adresse {
  private _id: number;
  private _numero: string;
  private _voie: string;
  private _code: string;
  private _commune: string;
  private _region: string;
  private _departement: string;
  private _benevoles: Array<Benevole>;
  private _associations: Array<Association>;
  private _missions: Array<Mission>;

  constructor() {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }


  get numero(): string {
    return this._numero;
  }

  set numero(value: string) {
    this._numero = value;
  }

  get voie(): string {
    return this._voie;
  }

  set voie(value: string) {
    this._voie = value;
  }

  get code(): string {
    return this._code;
  }

  set code(value: string) {
    this._code = value;
  }

  get commune(): string {
    return this._commune;
  }

  set commune(value: string) {
    this._commune = value;
  }

  get region(): string {
    return this._region;
  }

  set region(value: string) {
    this._region = value;
  }

  get departement(): string {
    return this._departement;
  }

  set departement(value: string) {
    this._departement = value;
  }


  get benevoles(): Array<Benevole> {
    return this._benevoles;
  }

  set benevoles(value: Array<Benevole>) {
    this._benevoles = value;
  }

  get associations(): Array<Association> {
    return this._associations;
  }

  set associations(value: Array<Association>) {
    this._associations = value;
  }

  get missions(): Array<Mission> {
    return this._missions;
  }

  set missions(value: Array<Mission>) {
    this._missions = value;
  }

    jsonToAdresse(featureJson: Feature) {
    this._numero = featureJson.properties.housenumber;
    this._voie = featureJson.properties.name;
    this._code = featureJson.properties.postcode;
    this._commune = featureJson.properties.city;
    this._departement = featureJson.properties.context;

  }
}
