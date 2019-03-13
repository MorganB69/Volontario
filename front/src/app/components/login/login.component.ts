import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {TokenStorage} from '../../model/TokenStorage';
import {ActivatedRoute, Router} from '@angular/router';
import {switchMap} from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: UserService, private token: TokenStorage, private router: Router, private route: ActivatedRoute) { }
  @Input()
  username: string;
  @Input()
  password: string;
  loginError = false;

  url: string;

  ngOnInit() {
    this.url = this.route.snapshot.queryParams['url'];
  }

  login(): void {
    console.log(this.username);
    console.log(this.url);
    this.authService.Auth(this.username, this.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        if (this.url) {
          this.authService.redirectWithUrl(this.url);
        } else {
          this.authService.redirect();
        }

      },
      error1 => {this.loginError = true; }
    );
  }

  loginUrl(url: string): void {
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
