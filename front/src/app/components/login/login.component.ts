import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {TokenStorage} from '../../model/TokenStorage';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: UserService, private token: TokenStorage, private router: Router) { }
  @Input()
  username: string;
  @Input()
  password: string;
  loginError = false;

  ngOnInit() {
  }

  login(): void {
    console.log(this.username);
    this.authService.Auth(this.username, this.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        this.authService.redirect();
      },
      error1 => {this.loginError = true; }
    );
  }

}
