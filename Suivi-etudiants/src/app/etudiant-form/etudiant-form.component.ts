import { Component } from '@angular/core';
import { Etudiant }    from '../etudiant';

@Component({
  selector: 'app-etudiant-form',
  templateUrl: './etudiant-form.component.html',
  styleUrls: ['./etudiant-form.component.css']
})
export class EtudiantFormComponent {

  departement = ['IRT', 'MPG',
            'GC-HE', 'GM','E3A'];
  typeMobilite = ['Echange', 'Double-Diplôme (DD)',
            'Autre'];

  ecole = ['INSA de Lyon', 'ENIS',
            'ESP'];
  
  model = new Etudiant();
 
  submitted = false;

  onSubmit() { this.submitted = true; }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

}
