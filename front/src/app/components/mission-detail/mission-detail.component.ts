import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Mission} from '../../model/Mission';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';
import {HttpParams} from '@angular/common/http';
import {User} from '../../model/User';
import {Observable, of, Subject} from 'rxjs';

@Component({
  selector: 'app-mission-detail',
  templateUrl: './mission-detail.component.html',
  styleUrls: ['./mission-detail.component.css']
})
export class MissionDetailComponent implements OnInit {


  mission: Mission ;
  missionId: string;
  inscriptionId: string;
  notfound = false;
  user: User = new User();

  constructor(private route: ActivatedRoute,
              private missionService: MissionService,
              private authService: UserService,
              private router: Router) { }

  ngOnInit() {
    if (this.getAuthenticated()) {
      this.getUser();
    }
    this.missionId = this.route.snapshot.params['id'];
    this.getMissionById(this.missionId);

  }

  getUser() {
    this.authService.getUser().subscribe(
      res => this.user = res
    );
  }

  getAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }

  getMissionById(id: string) {
    this.missionService.getMissionById(id).subscribe(
      res => {this.mission = res;
      if (res) {this.mission.association.imagetoshow = this.getImage(this.mission); }}
    , error => this.notfound = true );
    return this.mission;
}

inscrire(id: number) {
  this.missionService.addUserToMission(id).subscribe(value => {
    if (value) {
      this.getUser();
    } else {
    }
    });
}
desinscrire(id: number) {
    this.missionService.deleteUserToMission(id).subscribe(value => {
      if (value) {
        this.getUser();
      } else {
      }
    });
}



checkInscription(idInscription: number): boolean {
    let retour = false;
    if (this.user.benevole.inscriptions) {
    for (const inscription of this.user.benevole.inscriptions) {
      if (inscription.idInscription === idInscription) {
        retour = true;
      }
    }
  }
    return retour;
}

login(id: string) {
    const params = ('/detail/' + id);
    this.router.navigate(['/login'], { queryParams: { url: params } });
}

  getImage(mission: Mission) {
    if (mission.association.photo !== null) {
      this.missionService.getImage(mission.association.photo).subscribe(
        data => {
          this.createImageFromBlob(data, mission);
        }, error => {
          console.log(error);
        });
      return mission.association.imagetoshow;
    }
  }

  createImageFromBlob(image: Blob, mission: Mission) {
    const reader = new FileReader();
    reader.addEventListener('load', () => {
      mission.association.imagetoshow = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

}
