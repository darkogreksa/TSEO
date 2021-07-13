import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/_service/student.service';

@Component({
  selector: 'app-prijava-ispita',
  templateUrl: './prijava-ispita.component.html',
  styleUrls: ['./prijava-ispita.component.css']
})
export class PrijavaIspitaComponent implements OnInit {

  id: number;
  ispiti;
  searchStudentForm: FormGroup;

  constructor(
    private studentService: StudentService, 
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) 
  { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.studentService.getPrijava(this.id).subscribe((i: any) => {
            console.log(i);
            if (i) {
              this.ispiti = i;
            }
          });
         }
    });

    this.searchStudentForm = new FormGroup({
      searchQuery: new FormControl()
    });
  }

}
