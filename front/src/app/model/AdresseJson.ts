interface AdresseJson {
  attribution: string;
  licence: string;
  query: string;
  type: string;
  version: string;
  features: Feature[];
}

interface Feature {
  properties: Properties;
  geometry: Geometry;
  type: string;
}

interface Geometry {
  type: string;
  coordinates: number[];
}

interface Properties {
  context: string;
  housenumber: string;
  label: string;
  postcode: string;
  citycode: string;
  id: string;
  score: number;
  name: string;
  city: string;
  type: string;
}
