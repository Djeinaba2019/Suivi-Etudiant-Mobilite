import { Component, OnInit } from '@angular/core';
import { EcolePartenaireService } from '../ecole-partenaire.service';
import { EcolePartenaire} from '../ecole';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-ListeEcole',
  templateUrl: './ListeEcole.component.html',
  styleUrls: ['./ListeEcole.component.css']
})
export class ListeEcole implements OnInit {

  Ecoles : Observable<EcolePartenaire[]>;


  //on crée une instance de la classe service
  constructor(private service : EcolePartenaireService) { }

  ngOnInit(): void {
    this.ListerEcole();
  }

  ListerEcole(){
    this.Ecoles= this.service.getAllEcolePartenaire();
  }

  SuppressionEcole(id: number){
    this.service.deleteEcoleById(id)
    .subscribe(
      data => {
        console.log(data);
        this.ListerEcole();
      },
      error => console.log(console.error()
      )
    );
  }

}
