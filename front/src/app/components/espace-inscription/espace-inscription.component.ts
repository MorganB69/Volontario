import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';
import {Inscription} from '../../model/Inscription';
import {Mission} from '../../model/Mission';


@Component({
  selector: 'app-espace-inscription',
  templateUrl: './espace-inscription.component.html',
  styleUrls: ['./espace-inscription.component.css']
})
export class EspaceInscriptionComponent implements OnInit {

  missionId: string;
  mission: Mission;
  inscriptions: Array<Inscription>;
  isEmpty: boolean;
  newInscription: Inscription = new Inscription();
  options = {
    locale: 'fr',
    icons: {
      time: 'fa fa-clock'
    }
  };

  constructor(private route: ActivatedRoute,
              private missionService: MissionService,
              private authService: UserService,
              private router: Router) {
  }


  ngOnInit() {
    this.missionId = this.route.snapshot.params['id'];
    this.getInscriptionsByIdMission(this.missionId);
    this.getMissionById(this.missionId);
    console.log(this.inscriptions);
  }

  getInscriptionsByIdMission(idMission: string) {
    this.missionService.getInscriptionsByIdMission(idMission).subscribe(
      res => {
        if (res) {
          this.inscriptions = res;
        }
      }
    );
  }

  getMissionById(idMission: string) {
    this.missionService.getMissionById(idMission).subscribe(
      res => {
        if (res) {
          this.mission = res;
        }
      }
    );
  }

  saveInscription() {
    this.missionService.saveInscription(this.missionId, this.newInscription).subscribe(
      res => {
        if (res) {
          this.getInscriptionsByIdMission(this.missionId);
        }
      }
    );
  }

  delete(idInscription: number) {
    this.missionService.deleteInscription(idInscription.toString()).subscribe();
    this.getInscriptionsByIdMission(this.missionId);
  }
}
