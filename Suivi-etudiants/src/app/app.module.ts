
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EtudiantFormComponent } from './etudiant-form/etudiant-form.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { FormComponent } from './form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    EtudiantFormComponent,
    ThankYouComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
