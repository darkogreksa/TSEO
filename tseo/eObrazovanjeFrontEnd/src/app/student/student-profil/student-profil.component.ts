import { saveAs } from 'file-saver';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/_service/student.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/_model/student';
import { HttpResponse } from '@angular/common/http';
import { KorisnikService } from 'src/app/_service/korisnik.service';
import { Korisnik } from 'src/app/_model/korisnik.model';
import { DokumentiService } from 'src/app/_service/dokumenti.service';

@Component({
  selector: 'app-student-profil',
  templateUrl: './student-profil.component.html',
  styleUrls: ['./student-profil.component.css']
})
export class StudentProfilComponent implements OnInit {

  student: Student;
  korisnik: Korisnik;
  editStudentForm:  FormGroup;
  id: number;
  selectedFiles: FileList;
	currentFile: File;
  uploadFile:  FormGroup;
  enableEdit: boolean;

  


  constructor(
    private studentService: StudentService, 
    private korisnikService: KorisnikService,
    private dokumentService: DokumentiService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    ) {}



  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.studentService.getId(this.id).subscribe((s: Student) => {
            console.log(s);
            if (s) {
              this.student = s;
          
              if(this.student.korisnik.id!=null){
                console.log("jmbg nije null: "+this.student.korisnik);
                console.log(this.student.korisnik);
                this.enableEdit = false;
              }else{
                this.enableEdit = true;
              }

            }
          });
         }
    });
    this.uploadFile = this.fb.group({
      file: ['']
    });

    console.log(this.student);
    // if(this.student.jmbg!=null){
    //   console.log("jmbg nije null: "+this.student.jmbg);
    // }
  }

  createUser() {
    this.korisnik = {
      id: 6,
      korisnickoIme: this.student.brIndeksa + this.student.smer,
      student: this.student.id,
      nastavnik: null
      // datumKreiranja: Date.toString
    };
    // this.selectedFiles = event.target.files;
    // korisnik.korisnickoIme = "lele";
    console.log(this.student);
    this.korisnikService.add(this.korisnik).subscribe(res =>{
      console.log("kreiran korisnik");
    });
    // this.upload(this.selectedFiles);

  }

  downloadFile(fileName) {
    console.log("fileName : " + fileName);
    const extension = fileName.substr(fileName.lastIndexOf('.') + 1)
    this.dokumentService.downloadFile(fileName)
    .subscribe(data => {
      saveAs(new Blob([data]), fileName);
    })
  }

  selectFile(event) {
    // this.selectedFiles = event.target.files;
    // console.log(this.selectedFiles);
    // this.upload(this.selectedFiles);

    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      console.log("FILEEEEEEEEE " + file);
      this.uploadFile.get('file').setValue(file);
    }
  }

  upload() {
    var data = new FormData();
    data.append('file', this.uploadFile.get('file').value);
    console.log(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/api/dokument/upload/" + this.id);

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        
    }
      
    xhr.send(data);
  }
}
