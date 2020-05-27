import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EcolePartenaireComponent } from './ecole-partenaire/ecole-partenaire.component';
import { ListeEcole } from './ListeEcole/ListeEcole.component';


const routes: Routes = [
  { path: '', redirectTo: 'listeEcoles', pathMatch: 'full' },
  {path:'listeEcoles', component: ListeEcole},
  {path:'ecole',component: EcolePartenaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
