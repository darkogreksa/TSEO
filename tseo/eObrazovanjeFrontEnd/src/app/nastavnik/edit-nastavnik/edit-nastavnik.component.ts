import { Component, OnInit } from '@angular/core';
import { Nastavnik } from 'src/app/_model/nastavnik';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NastavnikService } from 'src/app/_service/nastavnik.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-nastavnik',
  templateUrl: './edit-nastavnik.component.html',
  styleUrls: ['./edit-nastavnik.component.css']
})
export class EditNastavnikComponent implements OnInit {
  nastavnik: Nastavnik;
  editNastavnikForm: FormGroup;
  id: number;

  constructor(
    private nastavnikService: NastavnikService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.createForm();
    this.route.params.subscribe(params => {
      this.id = params['id'];
      if (this.id) {
        this.nastavnikService.getOne(this.id).subscribe((n: Nastavnik) => {
          if (n) {
            this.nastavnik = n;
            this.editNastavnikForm.controls.inputIme.setValue(n.ime);
            this.editNastavnikForm.controls.inputPrezime.setValue(n.prezime);
            this.editNastavnikForm.controls.inputJmbg.setValue(n.jmbg);
            this.editNastavnikForm.controls.inputMesto.setValue(n.mestoStanovanja);
          }
        });
      }
    });
  }

  createForm() {
    this.editNastavnikForm = this.fb.group({
      inputIme: ['', Validators.required],
      inputPrezime: ['', Validators.required],
      inputJmbg: ['', Validators.required],
      inputMesto: ['', Validators.required],
    });
  }

  onSubmit() {
    const ime: string = this.editNastavnikForm.controls.inputIme.value;
    const prezime: string = this.editNastavnikForm.controls.inputPrezime.value;
    const jmbg: string = this.editNastavnikForm.controls.inputJmbg.value;
    const mestoStanovanja: string = this.editNastavnikForm.controls.inputMesto.value;

    this.nastavnik.ime = ime;
    this.nastavnik.prezime = prezime;
    this.nastavnik.jmbg = jmbg;
    this.nastavnik.mestoStanovanja = mestoStanovanja;
    
    this.nastavnikService.add(this.nastavnik)
      .subscribe(() => this.router.navigateByUrl('nastavnik'));
  }

}
