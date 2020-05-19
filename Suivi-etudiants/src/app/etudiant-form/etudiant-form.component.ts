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
  
  model = new Etudiant('18067', 'Wafaa', 'Sidi', '1234567', 'wevasidi@gmail.com','123456','1-1-1800');
 
  submitted = false;

  onSubmit() { this.submitted = true; }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

}
