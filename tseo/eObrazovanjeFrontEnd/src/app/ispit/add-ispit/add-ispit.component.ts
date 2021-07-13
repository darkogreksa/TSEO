import { Component, OnInit, ViewChild } from "@angular/core";
import { IspitniRokService } from "src/app/_service/ispitni-rok.service";
import { PredmetService } from "src/app/_service/predmet.service";
import { IspitService } from "src/app/_service/ispit.service";
import { RouterLink, Router } from "@angular/router";

@Component({
  selector: "app-add-ispit",
  templateUrl: "./add-ispit.component.html",
  styleUrls: ["./add-ispit.component.css"]
})
export class AddIspitComponent implements OnInit {
  predmeti;
  rokovi;
  ispit = {
    predmet: { name: null },
    ispitniRok: { name: null },
    ucionica: null,
    datum: null,
    vrsta: null
  };
  errorMsg;
  ispitniRok;
  predmet;
  ulogovan;

  constructor(
    private ispitService: IspitService,
    private ispitniRokService: IspitniRokService,
    private predmetService: PredmetService,
    private router: Router
  ) {}

  @ViewChild("selectPredmet") selectPredmet = {
    nativeElement: { value: null }
  };
  @ViewChild("selectRok") selectRok = {
    nativeElement: { value: null }
  };

  ngOnInit() {
    this.predmetService.getAll().subscribe(res => {
      this.predmeti = res;
    });
    this.ispitniRokService.getAll().subscribe(res => {
      this.rokovi = res;
    });

    this.ulogovan = JSON.parse(localStorage.getItem("userInfo"));
    console.log(this.ulogovan);
  }

  validate() {
    if (
      !(
        this.ispitniRok.datumPocetka < this.ispit.datum &&
        this.ispitniRok.datumZavrsetka > this.ispit.datum
      )
    ) {
      this.errorMsg = "Neispravan datum";
      return false;
    }
    if (
      this.selectPredmet.nativeElement.value == "Izaberite predmet" ||
      this.selectRok.nativeElement.value == "Izaberite ispitni rok" ||
      this.ispit.ucionica == ""
    ) {
      this.errorMsg = "Morate popuniti sva polja";
      return false;
    }
  }
  addIspit() {
    this.ispitniRok = this.rokovi.filter(
      r => r.naziv == this.selectRok.nativeElement.value
    )[0];
    this.ispit.ispitniRok = this.ispitniRok;
    console.log(this.ispit.ispitniRok);

    if (this.ulogovan.role == "admin") {
      this.ispit.vrsta = "ispit";
    } else if (this.ulogovan.role == "profesor") {
      this.ispit;
    }
    this.predmet = this.predmeti.filter(
      p => p.naziv == this.selectPredmet.nativeElement.value
    )[0];
    this.ispit.predmet = this.predmet;
    if (this.validate) {
      this.ispitService.addIspit(this.ispit).subscribe(res => {
        console.log(this.ispit);
        this.router.navigateByUrl("/admin");
      });
    }
  }
}
