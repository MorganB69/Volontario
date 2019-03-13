import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Token} from '../../model/Token';
import {Router} from '@angular/router';
import {TokenStorage} from '../../model/TokenStorage';
import {JwtHelperService} from '@auth0/angular-jwt';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {


  public redirectUrl: string;

  constructor(private http: HttpClient, private  router: Router, private tokenStorage: TokenStorage, public jwtHelper: JwtHelperService) {
  }
  baseUrl = environment.baseUrl;

  Auth(username: string, password: string): Observable<Token> {
    const credentials = {username: username, password: password};

    return this.http.post<Token>(this.baseUrl + 'token/generate-token', credentials, httpOptions);

  }

  redirect(): void {
    console.log('redirect');
    console.log(this.redirectUrl);
    if (this.redirectUrl) {
      console.log(this.redirectUrl);
      this.router.navigate([this.redirectUrl]);
      this.redirectUrl = null;
    } else {
      this.router.navigate(['accueil']);
    }
  }

  redirectWithUrl(url: string): void {
    console.log('redirect');
    console.log(url);

      this.router.navigate([url]);

  }

  public isAuthenticated(): boolean  {
    const token = this.tokenStorage.getToken();
    return !this.jwtHelper.isTokenExpired(token);
  }

  logout(): void {
    this.tokenStorage.signOut();
  }
}
