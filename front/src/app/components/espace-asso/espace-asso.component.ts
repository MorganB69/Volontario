import { Component, OnInit } from '@angular/core';
import {User} from '../../model/User';
import {ActivatedRoute, Router} from '@angular/router';
import {MissionService} from '../../services/mission/mission.service';
import {UserService} from '../../services/user/user.service';
import {Association} from '../../model/Association';
import {Mission} from '../../model/Mission';

@Component({
  selector: 'app-espace-asso',
  templateUrl: './espace-asso.component.html',
  styleUrls: ['./espace-asso.component.css']
})
export class EspaceAssoComponent implements OnInit {

  user: User = new User();
  association: Association = new Association();

  constructor(private route: ActivatedRoute,
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
          this.association = this.user.association;
          this.getImage(this.association);
          console.log(this.association);
        }
      }
    );
  }

  getImage(association: Association) {
    if (association.photo !== null) {
      this.missionService.getImage(association.photo).subscribe(
        data => {
          this.createImageFromBlob(data, association);
        }, error => {
          console.log(error);
        });
      return association.imagetoshow;
    }
  }

  createImageFromBlob(image: Blob, association: Association) {
    const reader = new FileReader();
    reader.addEventListener('load', () => {
      association.imagetoshow = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

}
