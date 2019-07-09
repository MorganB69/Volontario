import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AssociationService} from '../../services/association/association.service';
import {Association} from '../../model/Association';
import {Domaine} from '../../model/Domaine';
import {MissionService} from '../../services/mission/mission.service';

@Component({
  selector: 'app-edit-asso',
  templateUrl: './edit-asso.component.html',
  styleUrls: ['./edit-asso.component.css']
})
export class EditAssoComponent implements OnInit {

  idAssociation: string;
  association: Association;
  domaines: Array<Domaine> = new Array<Domaine>();
  assoDomaines: Array<Domaine> = new Array<Domaine>();

  constructor(private route: ActivatedRoute, private router: Router, private assoService: AssociationService, private missionService: MissionService) { }

  ngOnInit() {
    this.idAssociation = this.route.snapshot.params['id'];
    this.getDomaines();
    this.assoService.getAssociation(this.idAssociation).subscribe(res => {
      this.association = res;
      if (this.association) {
        for (const domaineAsso of this.domaines) {
          if (this.association.domaines.map(a => a.idDomaine).includes(domaineAsso.idDomaine)) {
            this.assoDomaines.push(domaineAsso);
          }
        }
      }
      this.association.domaines = this.assoDomaines;
    });
  }

  getDomaines() {
    this.missionService.getDomaines().subscribe(
      (response) => this.domaines = response,
      (error) => console.log('error domaine'));
    return this.domaines;
  }

  onSubmit() {
    this.assoService.saveAssociation(this.association).subscribe(res => {
      if (res) {
        this.router.navigate(['espaceAsso']);
      }
    });
  }

}
