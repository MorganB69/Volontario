import {Association} from './Association';
import {Mission} from './Mission';

export class Domaine {
  private _id: number;
  private _nom: string;
  private _description: string;
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
}