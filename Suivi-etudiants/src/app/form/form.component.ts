import { Component, OnInit } from '@angular/core';
import { Departement } from '../departement';
import { TypeMobilite } from '../type-mobilite';
import { Observable } from "rxjs";
import { EtabliPartenaire } from '../etabli-partenaire';
import { EtudiantFormService } from '../etudiant-form-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Etudiant } from '../etudiant';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  etudiant: Etudiant = {matricule: 1800, nom: 's', prenom:'s',nni:'5',telephone:'5',email:'s',dateDeNaissance:'1999-1-1', typeMobilite:{typeMobilite_Id:1,libelle:''},departement:{codeDep:'IRT',nom:'',etudiants:[]},choix1:{id:1,nom:''}, choix2:{id:1,nom:''}, choix3:{id:1,nom:''}};
  submitted = false;
  departements: Observable<Departement[]>;
  typeMobili: Observable<TypeMobilite[]>;
  ecoles: Observable<EtabliPartenaire[]>;


  constructor(private router: Router, private etudiantFormService: EtudiantFormService) { }

  ngOnInit() {
    this.reloadData();
   
  }


  reloadData() {
    this.departements = this.etudiantFormService.getDepartementList();
    this.ecoles = this.etudiantFormService.getEcoleList();
    this.typeMobili = this.etudiantFormService.getTypeMobiliteList();
  }
  
  newEtudiant(): void {
    this.submitted = false;
    this.etudiant = new Etudiant();
  }

  save() {
    this.etudiantFormService.createEtudiant(this.etudiant)
      .subscribe(data => console.log(data), error => console.log(error));
    this.etudiant = new Etudiant();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/thank-you']);
  }



}