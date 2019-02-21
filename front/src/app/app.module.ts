import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { MissionsComponent } from './components/missions/missions.component';
import { MissionDetailComponent } from './components/mission-detail/mission-detail.component';
import { LoginComponent } from './components/login/login.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './components/footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatAutocompleteModule, MatFormFieldModule, MatInputModule} from '@angular/material';
import { InscriptionBenevoleComponent } from './components/inscription-benevole/inscription-benevole.component';
import { FormUploadComponent } from './components/form-upload/form-upload.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccueilComponent,
    MissionsComponent,
    MissionDetailComponent,
    LoginComponent,
    InscriptionComponent,
    FooterComponent,
    InscriptionBenevoleComponent,
    FormUploadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule
  ],


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
