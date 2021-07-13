import { StudentService } from './../../_service/student.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Student } from './../../_model/student';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from 'src/app/_model/korisnik.model';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student: Student;
  // korisnik: Korisnik;
  addStudentForm:  FormGroup;
   
  constructor(
    private studentService: StudentService, 
    private fb: FormBuilder,
    private router: Router
    ) {}

   ngOnInit() {
    this.createForm();
    this.addStudentForm = new FormGroup({
      inputIme: new FormControl(),
      inputPrezime: new FormControl(),
      inputJmbg: new FormControl(),
      inputMesto: new FormControl(),
      inputSmer: new FormControl(),
      inputBrIndeksa: new FormControl()
    });
  }
 
  createForm() {
    this.addStudentForm = this.fb.group({
      inputIme: ['', Validators.required],
      inputPrezime: ['', Validators.required],
      inputJmbg: ['', Validators.required],
      inputMesto: ['', Validators.required],
      inputSmer: ['', Validators.required],
      inputBrIndeksa: ['', Validators.required]
    });
  }

  onSubmit(){
    const ime: string = this.addStudentForm.controls.inputIme.value;
    const prezime: string = this.addStudentForm.controls.inputPrezime.value;
    const jmbg: string = this.addStudentForm.controls.inputJmbg.value;
    const mestoStanovanja: string = this.addStudentForm.controls.inputMesto.value;
    const smer: string = this.addStudentForm.controls.inputSmer.value;
    const brIndeksa: string = this.addStudentForm.controls.inputBrIndeksa.value;
    const korisnik = {
      id: 1,
      korisnickoIme: "a",
      student: 1,
      nastavnik: 1
    }
    // this.korisnik = {
    //   id = 0,

    // }
    // const korisnik: Korisnik = korisnik.id=0;


   const student: Student = {id: 0, ime, prezime, jmbg, mestoStanovanja, smer, brIndeksa, korisnik};
   this.studentService.add(student)
     .subscribe(() => this.router.navigateByUrl('student'));

  }

}
