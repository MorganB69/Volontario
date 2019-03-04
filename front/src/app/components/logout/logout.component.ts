import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: UserService, private router: Router) { }

  ngOnInit() {
    this.authService.logout();
    this.router.navigate(['accueil']);
  }

}
