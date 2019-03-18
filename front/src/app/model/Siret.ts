export interface Refine {
  siret: string;
}

export interface Parameters {
  dataset: string[];
  refine: Refine;
  timezone: string;
  rows: number;
  format: string;
}

export interface Fields {
  efetcent: string;
  tcd: string;
  arronet: string;
  apet700: string;
  tu: string;
  lieuact: string;
  diffcom: string;
  l4_normalisee: string;
  categorie: string;
  libmonoact: string;
  dateess: string;
  auxilt: string;
  du: string;
  code_groupe: string;
  activite: string;
  tefen: string;
  zemet: string;
  tefet: string;
  l6_declaree: string;
  l6_normalisee: string;
  iriset: string;
  proden: string;
  ess: string;
  libapen: string;
  section: string;
  libapet: string;
  numvoie: string;
  prodet: string;
  codpos: string;
  monoact: string;
  dcren: string;
  amintren: string;
  siege: string;
  libreg_new: string;
  libessen: string;
  nicsiege: string;
  dcret: string;
  amintret: string;
  l7_normalisee: string;
  origine: string;
  saisonat: string;
  sous_classe: string;
  comet: string;
  libtefen: string;
  libcom: string;
  epci: string;
  ddebact: string;
  libtefet: string;
  nom_dept: string;
  libvoie: string;
  datemaj: Date;
  l1_declaree: string;
  l4_declaree: string;
  dapen: string;
  depet: string;
  code_division: string;
  nomen_long: string;
  activnat: string;
  uu: string;
  libnj: string;
  rpen: string;
  ind_publipo: string;
  rpet: string;
  defet: string;
  typvoie: string;
  dapet: string;
  l1_normalisee: string;
  code_section: string;
  defen: string;
  code_classe: string;
  libtu: string;
  nj: string;
  depcomet: string;
  depcomen: string;
  siret: string;
  libactivnat: string;
  apen700: string;
  nic: string;
  siren: string;
  libmoden: string;
  libmodet: string;
  coordonnees: number[];
  modet: string;
  efencent: string;
  moden: string;
  liborigine: string;
}

export interface Geometry {
  type: string;
  coordinates: number[];
}

export interface Record {
  datasetid: string;
  recordid: string;
  fields: Fields;
  geometry: Geometry;
  record_timestamp: Date;
}

export interface Facet {
  name: string;
  path: string;
  count: number;
  state: string;
}

export interface FacetGroup {
  name: string;
  facets: Facet[];
}

export interface Siret {
  nhits: number;
  parameters: Parameters;
  records: Record[];
  facet_groups: FacetGroup[];
}
