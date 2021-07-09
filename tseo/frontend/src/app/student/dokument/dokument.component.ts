import { DokumentiService } from './../../service/dokumenti.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { StudentService } from 'src/app/service/student.service';
import { Dokument } from 'src/app/model/dokument';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-dokument',
  templateUrl: './dokument.component.html',
  styleUrls: ['./dokument.component.css']
})
export class DokumentComponent implements OnInit {

  editStudentForm: FormGroup;
  id: number;
  dokumenti: Dokument;
  imageBlobUrl;
  
  public imagePath;
  imgURL: any;
   


  constructor(
    private studentService: StudentService, 
    private dokumentService: DokumentiService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    ) {}



  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.dokumentService.getDokumentByStudentId(this.id).subscribe((d: Dokument) => {
            console.log(d);
            if (d) {
              this.dokumenti = d;

              // this.preview(d[0].data);
            }
          });
         }
    });
  }
  
  downloadFile(fileName) {
    console.log("fileName : " + fileName);
    const extension = fileName.substr(fileName.lastIndexOf('.') + 1)
    this.dokumentService.downloadFile(fileName)
    .subscribe(data => {
      saveAs(new Blob([data]), fileName);
    })
  }


  // createImageFromBlob(image: Blob) {
  //   let reader = new FileReader();
  //   reader.addEventListener("load", () => {
  //     this.imageBlobUrl = reader.result;
  //   }, false);
  //   if (image) {
  //     reader.readAsDataURL(image);
  //   }
  // }

 
  preview(files) { 
    var reader = new FileReader();
    this.imagePath = files;
    console.log(files);
    reader.readAsDataURL(files); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result;
    }
  }


}
