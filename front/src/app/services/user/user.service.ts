import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Token} from '../../model/Token';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }
  baseUrl = environment.baseUrl;

  Auth(username: string, password: string): Observable<Token> {
    const credentials = {username: username, password: password};
    console.log('attempAuth ::');
    return this.http.post<Token>(this.baseUrl + 'token/generate-token', credentials);
  }
}
