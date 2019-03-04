import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import {Inject, Injectable, InjectionToken, Injector} from '@angular/core';
import * as Rollbar from 'rollbar';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ModalErrorComponent} from '../modal-error/modal-error.component';
import {ErrorService} from '../services/error/error.service';
import {TokenStorage} from '../model/TokenStorage';
import {Router} from '@angular/router';


export const RollbarService = new InjectionToken<Rollbar>('rollbar');
const TOKEN_HEADER_KEY = 'Authorization';
@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  constructor(@Inject(RollbarService) private rollbar: Rollbar,
              private modalService: NgbModal,
              private token: TokenStorage,
              private router: Router) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = request;
    if (this.token.getToken() != null) {
      authReq = request.clone({ headers: request.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this .token.getToken())});
    }
    return next.handle(authReq)
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
            if (error.status === 401) {
              this.router.navigate(['login']);
            } else
              if (error.status === 403) {
                errorMessage = `Vous n'avez pas accès à cette partie du site`;
                const modalRef = this.modalService.open(ModalErrorComponent);
                modalRef.componentInstance.error = errorMessage;
                this.router.navigate(['login']);
              } else {
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.error.message}`;
            const modalRef = this.modalService.open(ModalErrorComponent);
            modalRef.componentInstance.error = errorMessage;
            this.rollbar.error(error);
            console.log('server error :' + errorMessage);
          }}

          return throwError(errorMessage);
        })
      );
  }
}
