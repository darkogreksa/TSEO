import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IspitiZaPrijavu } from '../model/ispiti-za-prijavu';
import { IspitniRok } from '../model/ispitni-rok';
import { Predmet } from '../model/predmet';
import { IspitService } from '../service/ispit.service';
import { IspitniRokService } from '../service/ispitni-rok.service';
import { PredmetService } from '../service/predmet.service';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-prijava-ispita',
  templateUrl: './prijava-ispita.component.html',
  styleUrls: ['./prijava-ispita.component.css']
})
export class PrijavaIspitaComponent implements OnInit {
  predmeti: Predmet[];
  izlasci;
  sviIspiti;
  ispiti;
  rokovi: IspitniRok[];
  selektovani: IspitiZaPrijavu[];
  selectedRok;
  ulogovan: any;
  logged: string;
  rokForm: FormGroup;
  id = 0;
  nepolozeniPredmeti = [];

  constructor(
    private studentService: StudentService,
    private predmetService: PredmetService,
    private rokService: IspitniRokService,
    private ispitService: IspitService,
    private fb: FormBuilder,
    private route: ActivatedRoute
  ) {}

  @ViewChild("selectRok") selectRok = {
    nativeElement: { value: null }
  };

  @ViewChild("selectIspit") selectIspit = {
    nativeElement: { value: null }
  };

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params["id"];
      if (this.id) {
        this.studentService.getNepolozeni(this.id).subscribe((p: any) => {
          this.nepolozeniPredmeti = p;
        });
      }
    });
    this.getIspiti();
    this.getRokovi();
    this.getIzlasci();
    this.selectRok.nativeElement.value = 1;
    this.ulogovan = JSON.parse(localStorage.getItem("userInfo"));
    this.logged = this.ulogovan.korisnickoIme;
  }

  prijaviIspit(ispitId) {
    this.studentService.prijavi(ispitId, this.id).subscribe(res => {
      console.log(res);
      this.ispiti.forEach(i => {
        if (i.id == ispitId) i.prijavljen = true;
      });
    });
  }
  onChange() {
    this.selectedRok = this.selectRok.nativeElement.value;
    this.ispiti = [];
    this.sviIspiti.forEach(i => {
      if (i.ispitniRok.naziv == this.selectedRok) {
        i.prijavljen = false;
        this.ispiti.push(i);
      }
    });

    let tempIspiti = [];
    this.ispiti.forEach(i => {
      this.nepolozeniPredmeti.forEach(np => {
        if (i.predmet.id == np.id) {
          tempIspiti.push(i);
        }
      });
    });
    this.ispiti = tempIspiti;

    this.izlasci.forEach(iz => {
      this.ispiti.forEach(is => {
        if (iz.ispit.id == is.id && iz.student.id == this.id) {
          is.prijavljen = true;
        }
      });
    });
  }

  getIspiti() {
    this.ispitService.getAll().subscribe(ispiti => {
      this.sviIspiti = ispiti;
    });
  }

  getIzlasci() {
    this.studentService.getIzlasci().subscribe(i => {
      this.izlasci = i;
      console.log(this.izlasci);
    });
  }

  getPredmeti() {
    this.predmetService.getAll().subscribe(predmeti => {
      this.predmeti = predmeti;
    });
  }

  getRokovi() {
    this.rokService.getAll().subscribe(rokovi => {
      this.rokovi = rokovi;
    });
  }
}
