import { Etudiant } from './etudiant';

export class Departement {
    constructor(
        public codeDep: string,
        public nom: string,
        public etudiants:  Array<Etudiant> 
      ) {  }
}
