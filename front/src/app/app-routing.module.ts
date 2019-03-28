import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './components/accueil/accueil.component';
import {LoginComponent} from './components/login/login.component';
import {MissionsComponent} from './components/missions/missions.component';
import {Inscription} from './model/Inscription';
import {InscriptionComponent} from './components/inscription-association/inscription.component';
import {InscriptionBenevoleComponent} from './components/inscription-benevole/inscription-benevole.component';
import {AuthGuard} from './interceptors/AuthGard';
import {LogoutComponent} from './components/logout/logout.component';
import {NavInscriComponent} from './components/nav-inscri/nav-inscri.component';
import {MissionDetailComponent} from './components/mission-detail/mission-detail.component';
import {NavEspaceAssoComponent} from './components/nav-espace-asso/nav-espace-asso.component';
import {AuthGuardAsso} from './interceptors/AuthGardAsso';

const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: '', redirectTo: '/accueil', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'login/:url', component: LoginComponent},
  {path: 'recherche', component: MissionsComponent},
  {path: 'inscriptionAssociation', component: InscriptionComponent},
  {path: 'inscriptionBenevole', component: InscriptionBenevoleComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'inscription', component: NavInscriComponent},
  {path: 'espaceAsso', component: NavEspaceAssoComponent, canActivate: [AuthGuardAsso]},
  {path: 'detail/:id', component: MissionDetailComponent},
  {path: 'detail/:id/:idInscription', component: MissionDetailComponent, canActivate: [AuthGuard]}
];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
