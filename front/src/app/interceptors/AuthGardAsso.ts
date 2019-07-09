

import {UserService} from '../services/user/user.service';
import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {User} from '../model/User';

@Injectable({
  providedIn: 'root',
})
export class AuthGuardAsso implements CanActivate {
  constructor(private authService: UserService, private router: Router) {}
  user: User = new User();

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const url: string = state.url;
    if (this.authService.isAuthenticated()) {
      this.authService.getUser().subscribe(
        res => {
          this.user = res;
          if (this.user.role === 'ASSO') {
            this.authService.errorAsso.next(false);
          } else {
            this.authService.errorAsso.next(true);
          }
        }
      );
      return true;
      } else {
        this.authService.redirectUrl = url;
        this.router.navigate(['/login']);
        return false;
      }
    }
}
