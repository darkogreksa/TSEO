import { Component, OnInit } from '@angular/core';
import { Nastavnik } from 'src/app/_model/nastavnik';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NastavnikService } from 'src/app/_service/nastavnik.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-nastavnik',
  templateUrl: './add-nastavnik.component.html',
  styleUrls: ['./add-nastavnik.component.css']
})
export class AddNastavnikComponent implements OnInit {
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
