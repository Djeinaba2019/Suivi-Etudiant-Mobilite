import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EcolePartenaireComponent } from './ecole-partenaire/ecole-partenaire.component';
import { ListeEcole } from './ListeEcole/ListeEcole.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ImageModelComponent } from './image-model/image-model.component';


@NgModule({
  declarations: [
    AppComponent,
    EcolePartenaireComponent,
    ListeEcole,
    ImageModelComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
