export class Recherche {
  private _domaine: Array<number>;
  private _disponibilite: Array<number>;


  get domaine(): Array<number> {
    return this._domaine;
  }

  set domaine(value: Array<number>) {
    this._domaine = value;
  }

  get disponibilite(): Array<number> {
    return this._disponibilite;
  }

  set disponibilite(value: Array<number>) {
    this._disponibilite = value;
  }
}
