import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccueilComponent} from './components/accueil/accueil.component';
import {LoginComponent} from './components/login/login.component';
import {MissionsComponent} from './components/missions/missions.component';

const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: '', redirectTo: '/accueil', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  {path: 'recherche', component: MissionsComponent}
];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
