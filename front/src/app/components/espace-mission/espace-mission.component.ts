import { Component, OnInit } from '@angular/core';
import {AssociationService} from '../../services/association/association.service';
import {Domaine} from '../../model/Domaine';
import {Mission} from '../../model/Mission';
import {User} from '../../model/User';
import {ActivatedRoute, Router} from '@angular/router';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-espace-mission',
  templateUrl: './espace-mission.component.html',
  styleUrls: ['./espace-mission.component.css']
})
export class EspaceMissionComponent implements OnInit {

  missions: Array<Mission>;
  idAssociation: string;
  user: User;

  constructor(private assoService: AssociationService,
              private route: ActivatedRoute,
              private missionService: MissionService,
              private authService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    this.authService.getUser().subscribe(res => {
        if (res) {
          this.user = res;
          this.idAssociation = String(this.user.association.idAssociation);
          this.getMissionsByAsso();
        }
      }
    );
  }

  getMissionsByAsso() {
    this.assoService.getMissionsByAsso(this.idAssociation).subscribe(
      res => {
        this.missions = res;
        console.log(this.missions);
      }
    );
  }

}
