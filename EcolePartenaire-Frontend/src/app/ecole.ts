import {ImageModel} from './ImageModel'

export class EcolePartenaire{

    id : number;
    nom: String;
    quotas:number;
    email:String;
    telephone: String;
    adresse: String;
    site_web: String;
    ville:String;
    pays: String;
    type_Accords:String;
    specialite:String;
    photo: ImageModel;


}