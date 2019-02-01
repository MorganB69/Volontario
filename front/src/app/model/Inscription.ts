import {Timestamp} from 'rxjs';
import {Mission} from './Mission';
import {Benevole} from './Benevole';

export class Inscription {
  private _id: number;
  private _nbPlaces: number;
  private _debut: Date;
  private _fin: Date;
  private _mission: Mission;
  private _benevoles: Array<Benevole>;


  constructor() {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nbPlaces(): number {
    return this._nbPlaces;
  }

  set nbPlaces(value: number) {
    this._nbPlaces = value;
  }

  get debut(): Date {
    return this._debut;
  }

  set debut(value: Date) {
    this._debut = value;
  }

  get fin(): Date {
    return this._fin;
  }

  set fin(value: Date) {
    this._fin = value;
  }

  get mission(): Mission {
    return this._mission;
  }

  set mission(value: Mission) {
    this._mission = value;
  }

  get benevoles(): Array<Benevole> {
    return this._benevoles;
  }

  set benevoles(value: Array<Benevole>) {
    this._benevoles = value;
  }
}
