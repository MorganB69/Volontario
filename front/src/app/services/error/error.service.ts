import { Injectable } from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {
  private errorEvent = new Subject<string>();
  public errorEvent$ = this.errorEvent.asObservable();
  constructor() { }

  getError(error: string) {
    this.errorEvent.next(error);
  }
}
