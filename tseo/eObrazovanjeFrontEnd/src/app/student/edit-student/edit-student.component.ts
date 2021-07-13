import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/_model/student';
import { StudentService } from 'src/app/_service/student.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {
  
  s: Student;
  editStudentForm:  FormGroup;
  id: number;


  constructor(
    private studentService: StudentService, 
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    ) {}



  ngOnInit() {
    this.createForm();
    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.studentService.getId(this.id).subscribe((s: Student) => {
            console.log(s);
            if (s) {
              this.s = s;
              this.editStudentForm.controls['inputIme'].setValue(s.ime);
              this.editStudentForm.controls['inputPrezime'].setValue(s.prezime);
              this.editStudentForm.controls['inputJmbg'].setValue(s.jmbg);
              this.editStudentForm.controls['inputMesto'].setValue(s.mestoStanovanja);
              this.editStudentForm.controls['inputSmer'].setValue(s.smer);
              this.editStudentForm.controls['inputBrIndeksa'].setValue(s.brIndeksa);
            }
          });
         }
    });
  }

   
  createForm() {
    this.editStudentForm = this.fb.group({
      inputIme: ['', Validators.required],
      inputPrezime: ['', Validators.required],
      inputJmbg: ['', Validators.required],
      inputMesto: ['', Validators.required],
      inputSmer: ['', Validators.required],
      inputBrIndeksa: ['', Validators.required]
    });
  }

  onSubmit(){
    const ime: string = this.editStudentForm.controls.inputIme.value;
    const prezime: string = this.editStudentForm.controls.inputPrezime.value;
    const jmbg: string = this.editStudentForm.controls.inputJmbg.value;
    const mesto: string = this.editStudentForm.controls.inputMesto.value;
    const smer: string = this.editStudentForm.controls.inputSmer.value;
    const brIndeksa: string = this.editStudentForm.controls.inputBrIndeksa.value;

    this.s.id = this.id;
    this.s.ime = ime;
    this.s.prezime = prezime;
    this.s.jmbg = jmbg;
    this.s.mestoStanovanja = mesto;
    this.s.smer = smer;
    this.s.brIndeksa = brIndeksa;

    
    this.studentService.edit(this.s).subscribe( () => {
      student => this.s;
      this.router.navigateByUrl('/student');
    });
  }
}
