

import {UserService} from '../services/user/user.service';
import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private authService: UserService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const url: string = state.url;
    if (this.authService.isAuthenticated()) {
      return true; } else {
      this.authService.redirectUrl = url;
      this.router.navigate(['/login']);
      return false;
    }
  }
}
