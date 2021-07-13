import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { throwError, Observable } from "rxjs";
import { map, catchError } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class LoginService {
  constructor(private http: HttpClient, private router: Router) {}

  login(credentials): Observable<any> {
    return this.http.post("/api/korisnik/login", credentials).pipe(
      map((res: any) => {
        console.log(res);
        let token = res.jwt;
        if (token != null) {
          console.log(token);
          let jwtData = token.split(".")[1];
          let decodedJwtJsonData = window.atob(jwtData);
          let claims = JSON.parse(decodedJwtJsonData);
          let role = claims.role[0].authority;
          let id = claims.id;
          let userInfo = { username: credentials.username, role: role, id: id };
          localStorage.setItem("userInfo", JSON.stringify(userInfo));
          localStorage.setItem("token", token);
          return true;
        } else {
          return false;
        }
      }),
      catchError((error: any) => {
        if (error.status === 401) return throwError("Unauthorized");
        else return throwError(error || "Server error");
      })
    );
  }
}
