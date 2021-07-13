import { StudentService } from './../_service/student.service';
import { Component, OnInit } from '@angular/core';
import { Student } from '../_model/student';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  private svi: Student[] = [];
  searchStudentForm: FormGroup;
  studentPage = { size: null };
  currentPage;
  itemsPerPage;

  constructor(
    private studentService: StudentService
  ) { }

  ngOnInit() {

    this.getStudentPage(0,3);

    this.searchStudentForm = new FormGroup({
      searchQuery: new FormControl()
    });
  }

  getStudentPage(page: number, size: number) {
    this.studentService.getAllPaged(page, size).subscribe(page => {
      this.studentPage = page;
      this.svi = page.content;
    });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getStudentPage(this.currentPage - 1, this.itemsPerPage);
  }


  delete(id: number) {
    this.studentService.delete(id).subscribe(() => {
      for (let i = 0; i < this.svi.length; i++) {
        if (this.svi[i].id === id) {
          this.svi.splice(i, 1);
        }
      }
    }, error => {
     
    });
  }

  search(name){
    this.studentService.getByName(name).subscribe(
       (s: Student[]) =>{
          this.svi = s;
          console.log(s);
       },
         (error) => console.log(error)
       );
     console.log(name);
   }

}
