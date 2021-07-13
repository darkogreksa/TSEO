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
    this.getPredmetPage(0, 6);
    this.ulogovan = JSON.parse(localStorage.getItem("userInfo"));
    this.logged = this.ulogovan.korisnickoIme;
  }

  getPredmetPage(page: number, size: number) {
    this.ispitService.getAllPage(page, size).subscribe(page => {
      this.ispiti = page.content;
    });
  }

  onIspitiClick() {
    this.getPredmetPage(0, 6);
  }
}
