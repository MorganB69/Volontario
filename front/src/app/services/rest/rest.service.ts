import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Mission} from '../../model/Mission';
import {Recherche} from '../../model/Recherche';

@Injectable({
  providedIn: 'root'
})
export class RestService {


  constructor(private http: HttpClient) { }

}
