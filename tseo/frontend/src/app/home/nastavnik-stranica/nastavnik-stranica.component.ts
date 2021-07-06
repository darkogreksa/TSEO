import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IspitZaNastavnika } from 'src/app/model/ispit-za-nastavnika';
import { Korisnik } from 'src/app/model/korisnik';
import { Nastavnik } from 'src/app/model/nastavnik';
import { PredmetZaNastavnika } from 'src/app/model/predmet-za-nastavnika';
import { IspitService } from 'src/app/service/ispit.service';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { NastavnikService } from 'src/app/service/nastavnik.service';
import { PredmetService } from 'src/app/service/predmet.service';

@Component({
  selector: 'app-nastavnik-stranica',
  templateUrl: './nastavnik-stranica.component.html',
  styleUrls: ['./nastavnik-stranica.component.css']
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
      // student: null,
      student: 0,
      nastavnik: this.id
    };
    console.log(this.nastavnik);
    this.korisnikService.add(this.korisnik).subscribe(res => {
      console.log("kreiran korisnik");
      // this.router.navigate(["/nastavnik-stranica/"+this.id]);
    });
  }
}
