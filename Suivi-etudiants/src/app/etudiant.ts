import { Departement } from './departement';
import { EtabliPartenaire } from './etabli-partenaire';
import { TypeMobilite } from './type-mobilite';

export class Etudiant {
         matricule: number;
         nom: string;
         prenom: string;
         nni: string;
         email: string;
         telephone: string;
         dateDeNaissance: string; 
         typeMobilite: TypeMobilite;
         departement: Departement;
         choix1: EtabliPartenaire;
         choix2: EtabliPartenaire;
         choix3: EtabliPartenaire;
       
     
}
