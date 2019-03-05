import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  authenticated: boolean;
  constructor(private authService: UserService) { }

  ngOnInit() {
  }

  getAuthenticated(): boolean {
    return this.authService.isAuthenticated();
}

}
