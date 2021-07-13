import { Component, OnInit } from "@angular/core";
import { Korisnik } from "src/app/_model/korisnik.model";
import { Nastavnik } from "src/app/_model/nastavnik";
import { KorisnikService } from "src/app/_service/korisnik.service";
import { ActivatedRoute, Router } from "@angular/router";
import { NastavnikService } from "src/app/_service/nastavnik.service";
import { PredmetZaNastavnika } from "src/app/_model/predmet-za-nastavnika.model";
import { PredmetService } from "src/app/_service/predmet.service";
import { IspitZaNastavnika } from "src/app/_model/ispit-za-nastavnika.model";
import { IspitService } from "src/app/_service/ispit.service";

@Component({
  selector: "app-nastavnik-stranica",
  templateUrl: "./nastavnik-stranica.component.html",
  styleUrls: ["./nastavnik-stranica.component.css"]
})
export class NastavnikStranicaComponent implements OnInit {
  nastavnik: Nastavnik;
  korisnik: Korisnik;
  enableEdit: boolean;
  vidi: boolean;
  id: number;
  predmeti: PredmetZaNastavnika[];
  ispiti: IspitZaNastavnika[];
  kolokvijumi: IspitZaNastavnika[];
  nepregledaniIspiti: IspitZaNastavnika[];
  nepregledaniKolokvijumi: IspitZaNastavnika[];

  constructor(
    private korisnikService: KorisnikService,
    private route: ActivatedRoute,
    private router: Router,
    private nastavnikService: NastavnikService,
    private predmetService: PredmetService,
    private ispitService: IspitService
  ) {}

  ngOnInit() {
    this.enableEdit = true;
    this.vidi = false;
    this.route.params.subscribe(params => {
      this.id = params["id"];
      if (this.id) {
        this.nastavnikService.getOne(this.id).subscribe((s: Nastavnik) => {
          console.log(s);
          if (s) {
            this.nastavnik = s;

            if (this.nastavnik.korisnik.id != null) {
              console.log("korisnik nije null: " + this.nastavnik.korisnik);
              console.log(this.nastavnik.korisnik);
              this.enableEdit = false;
              this.vidi = true;
            } else {
              this.enableEdit = true;
              this.vidi = false;
            }

            this.predmetService
              .getAllByNastavnik(this.nastavnik.id)
              .subscribe(predmeti => {
                this.predmeti = predmeti;
              });

            this.ispitService
              .getAllByNastavnik(this.nastavnik.id)
              .subscribe(ispiti => {
                this.ispiti = ispiti;
              });

            this.ispitService
              .getAllKolokvijumiByNastavnik(this.nastavnik.id)
              .subscribe(kolokvijumi => {
                this.kolokvijumi = kolokvijumi;
              });

            this.nastavnikService
              .getIspitiForUpisOcenaByNastavnikId(this.nastavnik.id)
              .subscribe(ispiti => {
                this.nepregledaniIspiti = ispiti;
                console.log(ispiti);
              });

            this.nastavnikService
              .getKolokvijumiForUpisOcenaByNastavnikId(this.nastavnik.id)
              .subscribe(kolokvijumi => {
                this.nepregledaniKolokvijumi = kolokvijumi;
                console.log(kolokvijumi);
              });
          }
        });
      }
    });
  }

  createUser() {
    this.korisnik = {
      id: 6,
      korisnickoIme: this.nastavnik.ime + this.nastavnik.jmbg,
      student: null,
      nastavnik: this.id
      // datumKreiranja: Date.toString
    };
    console.log(this.nastavnik);
    this.korisnikService.add(this.korisnik).subscribe(res => {
      console.log("kreiran korisnik");
      // this.router.navigate(["/nastavnik-stranica/"+this.id]);
    });
  }
}
