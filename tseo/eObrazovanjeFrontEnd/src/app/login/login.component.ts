import { Component, OnInit } from "@angular/core";
import { throwError } from "rxjs";
import { Router } from "@angular/router";
import { LoginService } from "../_service/login-service/login.service";
import { StudentService } from "../_service/student.service";
import { NastavnikService } from "../_service/nastavnik.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  private korisnik: any = {};
  private badLogin: any = false;
  thisPage = "loginPage";
  studenti;
  student = {
    korisnik: {
      korisnickoIme: null
    }
  };
  nastavnici;
  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  login(): void {
    if (this.korisnik.username == null || this.korisnik.password == null) {
      this.badLogin = true;
    } else {
      this.loginService.login(this.korisnik).subscribe(
        (res: boolean) => {
          if (res) {
            if (JSON.parse(localStorage.getItem("userInfo")).role == "ADMIN") {
              this.router.navigate(["/admin"]);
            } else if (
              JSON.parse(localStorage.getItem("userInfo")).role == "STUDENT"
            ) {
              console.log("ovde je");
              this.router.navigateByUrl(
                "/student-profil/" +
                  JSON.parse(localStorage.getItem("userInfo")).id
              );
            } else if (
              JSON.parse(localStorage.getItem("userInfo")).role == "NASTAVNIK"
            ) {
              this.router.navigateByUrl(
                "/nastavnik-stranica/" +
                  JSON.parse(localStorage.getItem("userInfo")).id
              );
            }
          }
        },
        (err: Error) => {
          if (err.toString() === "Unauthorized") {
            console.log("Unauthorized");
            this.badLogin = true;
          } else {
            throwError(err);
          }
        }
      );
    }
  }
}
