import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './components/accueil/accueil.component';
import {LoginComponent} from './components/login/login.component';
import {MissionsComponent} from './components/missions/missions.component';
import {Inscription} from './model/Inscription';
import {InscriptionComponent} from './components/inscription/inscription.component';
import {InscriptionBenevoleComponent} from './components/inscription-benevole/inscription-benevole.component';

const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: '', redirectTo: '/accueil', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  {path: 'recherche', component: MissionsComponent},
  {path: 'inscription', component: InscriptionComponent},
  {path: 'inscriptionBenevole', component: InscriptionBenevoleComponent}
];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
