import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Nastavnik } from 'src/app/model/nastavnik';
import { NastavnikService } from 'src/app/service/nastavnik.service';

@Component({
  selector: 'app-nastavnik-add',
  templateUrl: './nastavnik-add.component.html',
  styleUrls: ['./nastavnik-add.component.css']
})
export class NastavnikAddComponent implements OnInit {
  nastavnik: Nastavnik;
  addNastavnikForm: FormGroup;

  constructor(
    private nastavnikService: NastavnikService,
    private fb: FormBuilder,
    private router: Router,
  ) { }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.addNastavnikForm = this.fb.group({
      inputIme: ['', Validators.required],
      inputPrezime: ['', Validators.required],
      inputJmbg: ['', [Validators.required, Validators.maxLength(13), Validators.minLength(13)]],
      inputMesto: ['', Validators.required],
    });
  }

  onSubmit() {
    const ime: string = this.addNastavnikForm.controls.inputIme.value;
    const prezime: string = this.addNastavnikForm.controls.inputPrezime.value;
    const jmbg: string = this.addNastavnikForm.controls.inputJmbg.value;
    const mestoStanovanja: string = this.addNastavnikForm.controls.inputMesto.value;
    const korisnik = {
      id: 1,
      korisnickoIme: "a",
      student: 1,
      nastavnik: 1
    }

    const newNastavnik: Nastavnik = {id: 0, ime, prezime, jmbg, mestoStanovanja, korisnik};
    this.nastavnikService.add(newNastavnik)
      .subscribe(() => this.router.navigateByUrl('nastavnik'));
  }
}
