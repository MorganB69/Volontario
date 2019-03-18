import {Benevole} from './Benevole';
import {Mission} from './Mission';
import {Association} from './Association';

export class Adresse {
  id: number;
  voie: string;
  code: string;
  commune: string;
  departement: string;
  benevoles: Array<Benevole>;
  associations: Array<Association>;
  missions: Array<Mission>;

  constructor() {
  }


    jsonToAdresse(featureJson: Feature) {
    this.voie = featureJson.properties.name;
    this.code = featureJson.properties.postcode;
    this.commune = featureJson.properties.city;
    this.departement = featureJson.properties.context;

  }
}
