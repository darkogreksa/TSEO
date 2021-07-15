import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { StudentService } from "../_service/student.service";
import { PredmetService } from "../_service/predmet.service";
import { IspitService } from "../_service/ispit.service";

@Component({
  selector: "app-admin",
  templateUrl: "./admin.component.html",
  styleUrls: ["./admin.component.css"]
})
export class AdminComponent implements OnInit {
  predmeti = [];
  ispiti = [];
  ulogovan;
  logged;
  constructor(
    private studentService: StudentService,
    private predmetService: PredmetService,
    private ispitService: IspitService
  ) {}

  ngOnInit() {
    this.ulogovan = JSON.parse(localStorage.getItem("userInfo"));
    this.logged = this.ulogovan.korisnickoIme;
  }

}
