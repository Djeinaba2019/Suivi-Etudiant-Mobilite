import { Component, OnInit } from '@angular/core';
import { EcolePartenaire}   from '../ecole';
import { EcolePartenaireService } from '../ecole-partenaire.service';

@Component({
  selector: 'app-ecole-partenaire',
  templateUrl: './ecole-partenaire.component.html',
  styleUrls: ['./ecole-partenaire.component.css']
})
export class EcolePartenaireComponent implements OnInit {

   ecole : EcolePartenaire = new EcolePartenaire();
   submitted = false;

  constructor(private service : EcolePartenaireService ) {}

  ngOnInit(): void {
  }

  newEcole() : void{
    this.submitted=false;
    this.ecole = new EcolePartenaire();
  }

  save() {
    this.service.createEcolePartenaire(this.ecole).subscribe(data => console.log(data), error => console.log(error));
    this.ecole= new EcolePartenaire();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }


}
