import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import {Inject, Injectable, InjectionToken, Injector} from '@angular/core';
import * as Rollbar from 'rollbar';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ModalErrorComponent} from '../modal-error/modal-error.component';
import {ErrorService} from '../services/error/error.service';


export const RollbarService = new InjectionToken<Rollbar>('rollbar');

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  constructor(@Inject(RollbarService) private rollbar: Rollbar, private modalService: NgbModal) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(
        retry(1),
        catchError((error: HttpErrorResponse) => {
          let errorMessage = '';
          if (error.error instanceof ErrorEvent) {
            // client-side error
            errorMessage = `Error: ${error.error.message}`;
            const modalRef = this.modalService.open(ModalErrorComponent);
            modalRef.componentInstance.error = errorMessage;
            this.rollbar.error(error);
            console.log('client-error :' + errorMessage);
          } else {
            // server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.error.message}`;
            const modalRef = this.modalService.open(ModalErrorComponent);
            modalRef.componentInstance.error = errorMessage;
            this.rollbar.error(error);
            console.log('server error :' + errorMessage);
          }

          return throwError(errorMessage);
        })
      );
  }
}
