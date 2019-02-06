import { Component, OnInit } from '@angular/core';
import {Domaine} from '../../model/Domaine';
import {MissionService} from '../../services/mission/mission.service';
import {Recherche} from '../../model/Recherche';
import {Mission} from '../../model/Mission';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrls: ['./missions.component.css']
})
export class MissionsComponent implements OnInit {

  domaines: Array<Domaine> = new Array<Domaine>();
  missions: Array<Mission> = new Array<Mission>();

  recherche: Recherche = new Recherche();
  domaineId: Array<number> = new Array<number>();


  constructor(private missionService: MissionService) {
  }

  ngOnInit() {

    this.getDomaines();
    this.getMissions();
  }

  getDomaines() {
    this.missionService.getDomaines().subscribe(
      (response) => this.domaines = response,
      (error) => console.log('error domaine'));
    return this.domaines;
  }

  getMissions() {
    this.missionService.rechercheMission(this.recherche).subscribe(
      (response) => this.missions = response,
      (error) => console.log('error recherche mission'));
    return this.missions;
  }

  refresh(form: NgForm) {
    console.log(form);
    this.recherche.domaine = this.domaineId;
    this.getMissions();
  }



}
