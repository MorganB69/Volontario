import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-nav-espace-asso',
  templateUrl: './nav-espace-asso.component.html',
  styleUrls: ['./nav-espace-asso.component.css']
})
export class NavEspaceAssoComponent implements OnInit {
  espacemission = false;
  espaceasso = true;
  errorAsso = true;


  constructor(private authService: UserService) { }

  ngOnInit() {
    this.getErrorAsso();
  }

  getErrorAsso() {
    this.authService.getErrorAsso().subscribe(
          res => this.errorAsso = res
    );
  }

  assoSelected() {
    this.espaceasso = true;
    this.espacemission = false;
  }
  missionSelected() {
    this.espaceasso = false;
    this.espacemission = true;
  }

}
