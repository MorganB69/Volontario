import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Token} from '../../model/Token';
import {Router} from '@angular/router';
import {TokenStorage} from '../../model/TokenStorage';
import {JwtHelperService} from '@auth0/angular-jwt';
import {User} from '../../model/User';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  public user: User;
  public redirectUrl: string;
  public errorAsso: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);


  constructor(private http: HttpClient, private  router: Router, private tokenStorage: TokenStorage, public jwtHelper: JwtHelperService) {
  }
  baseUrl = environment.baseUrl;

  Auth(username: string, password: string): Observable<Token> {
    const credentials = {username: username, password: password};

    return this.http.post<Token>(this.baseUrl + 'token/generate-token', credentials, httpOptions);

  }

  getErrorAsso(): Observable<boolean> {
    console.log('error' + this.errorAsso.value);
    return this.errorAsso.asObservable();
  }

  redirect(): void {
    console.log('redirect');
    console.log(this.redirectUrl);
    if (this.redirectUrl) {
      this.router.navigate([this.redirectUrl]);
      this.redirectUrl = null;
    } else {
      this.router.navigate(['accueil']);
    }
  }

  redirectWithUrl(url: string): void {


      this.router.navigate([url]);

  }

  public isAuthenticated(): boolean  {
    const token = this.tokenStorage.getToken();
    return !this.jwtHelper.isTokenExpired(token);
  }

  logout(): void {
    this.tokenStorage.signOut();
    this.errorAsso.next(true);
  }

  public getUser(): Observable<User> {
    if (this.isAuthenticated()) {
      return this.http.get<User>(this.baseUrl + 'user/getUser', httpOptions);
    }
  }

}
