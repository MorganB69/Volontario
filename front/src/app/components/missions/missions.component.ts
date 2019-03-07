import { Component, OnInit } from '@angular/core';
import {Domaine} from '../../model/Domaine';
import {MissionService} from '../../services/mission/mission.service';
import {Recherche} from '../../model/Recherche';
import {Mission} from '../../model/Mission';
import {NgForm} from '@angular/forms';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrls: ['./missions.component.css']
})
export class MissionsComponent implements OnInit {

  domaines: Array<Domaine> = new Array<Domaine>();
  missions: Array<Mission> = new Array<Mission>();
  departements: string[];
  communes: string[];
  selectedDep: string;
  selectedCom: string;

  dispo1 = true;
  dispo2 = true;
  dispo3 = true;
  dispo4 = true;

  recherche: Recherche = new Recherche();
  domaineId: Array<number> = new Array<number>();
  displayCommune = false;


  constructor(private missionService: MissionService) {
  }

  ngOnInit() {

    this.getDomaines();
    this.getMissions();
    this.getDepartements();
  }

  getDomaines() {
    this.missionService.getDomaines().subscribe(
      (response) => this.domaines = response,
      (error) => console.log('error domaine'));
    return this.domaines;
  }

  getDepartements() {
    this.missionService.getDetpartements().subscribe(
      (response) => {this.departements = response;
      },
      (error) => console.log('error adresses'));
    return this.departements;
  }

  onSelected(dep: string) {
    this.getCommunes(dep);
    this.displayCommune = true;
    console.log(this.displayCommune);
    console.log(dep);
    console.log(this.communes);
  }

  getCommunes(dep: string) {
    this.missionService.getCommunes(dep).subscribe(
      (response) => {this.communes = response;
      },
      (error) => console.log('error adresses'));
    return this.communes;
  }

  getMissions() {
    this.missionService.rechercheMission(this.recherche).subscribe(
      (response) => this.missions = response,
      (error) => console.log('error recherche mission'));
    return this.missions;
  }

  refresh(form: NgForm) {
    console.log(form);
    this.recherche.disponibilite = [];
    if (this.dispo1 === true) { this.recherche.disponibilite.push(1); }
    if (this.dispo2 === true) { this.recherche.disponibilite.push(2); }
    if (this.dispo3 === true) { this.recherche.disponibilite.push(3); }
    if (this.dispo4 === true) { this.recherche.disponibilite.push(4); }
    this.recherche.domaine = this.domaineId;
    this.getMissions();
  }



}
