import { Injectable } from "@angular/core";
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router
} from "@angular/router";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class NastavnikGuard implements CanActivate {
  constructor(private router: Router) {}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    if (
      localStorage.getItem("userInfo") &&
      (JSON.parse(localStorage.getItem("userInfo")).role == "ADMIN" ||
        JSON.parse(localStorage.getItem("userInfo")).role == "NASTAVNIK")
    ) {
      return true;
    }
    localStorage.clear();
    this.router.navigate(["login"]);
    return false;
  }
}
