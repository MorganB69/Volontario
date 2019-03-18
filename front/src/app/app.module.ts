import { BrowserModule } from '@angular/platform-browser';
import {InjectionToken, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { MissionsComponent } from './components/missions/missions.component';
import { MissionDetailComponent } from './components/mission-detail/mission-detail.component';
import { LoginComponent } from './components/login/login.component';
import { InscriptionComponent } from './components/inscription-association/inscription.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './components/footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatAutocompleteModule, MatFormFieldModule, MatInputModule} from '@angular/material';
import { InscriptionBenevoleComponent } from './components/inscription-benevole/inscription-benevole.component';
import { FormUploadComponent } from './components/form-upload/form-upload.component';
import {HttpErrorInterceptor, RollbarService} from './interceptors/HttpErrorInterceptor';
import { ModalErrorComponent } from './modal-error/modal-error.component';
import * as Rollbar from 'rollbar';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {environment} from '../environments/environment';
import {JwtModule} from '@auth0/angular-jwt';
import { LogoutComponent } from './components/logout/logout.component';
import { NavInscriComponent } from './components/nav-inscri/nav-inscri.component';
import {AngularFontAwesomeModule} from 'angular-font-awesome';







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
    FormUploadComponent,
    ModalErrorComponent,
    LogoutComponent,
    NavInscriComponent,
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
    MatInputModule,
    NgbModule,
    AngularFontAwesomeModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('AuthToken');
        },
        whitelistedDomains: ['localhost'],
        blacklistedRoutes: []
      }
    })
  ],

  entryComponents: [ModalErrorComponent],


  providers: [
    {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
