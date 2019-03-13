import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Mission} from '../../model/Mission';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';
import {HttpParams} from '@angular/common/http';

@Component({
  selector: 'app-mission-detail',
  templateUrl: './mission-detail.component.html',
  styleUrls: ['./mission-detail.component.css']
})
export class MissionDetailComponent implements OnInit {


  mission: Mission;
  private missionId: string;
  private inscriptionId: string;
  private notfound = false;
  authenticated: boolean;

  constructor(private route: ActivatedRoute, private missionService: MissionService, private authService: UserService, private router: Router) { }

  ngOnInit() {
    this.missionId = this.route.snapshot.params['id'];
    this.getMissionById(this.missionId);
  }

  getAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }

  getMissionById(id: string) {
    this.missionService.getMissionById(id).subscribe(
      res => {this.mission = res;
      this.mission.association.imagetoshow = this.getImage(this.mission); }
    , error => this.notfound = true );
    return this.mission;
}

inscrire(id: string) {
    
}

login(id: string) {
    const params = ('/detail/' + id);
    this.router.navigate(['/login'], { queryParams: { url: params } });
}

  getImage(mission: Mission) {
    this.missionService.getImage(mission.association.photo).subscribe(
      data => {
        this.createImageFromBlob(data, mission);
      }, error => {
        console.log(error);
      });
    return mission.association.imagetoshow;
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
