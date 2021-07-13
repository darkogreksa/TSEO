import { map } from 'rxjs/operators';
import { StudentService } from 'src/app/_service/student.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/_model/student';
import { IzlazakIspit } from 'src/app/_model/izlazakIspit.model';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-polozeni-ispiti',
  templateUrl: './polozeni-ispiti.component.html',
  styleUrls: ['./polozeni-ispiti.component.css']
})
export class PolozeniIspitiComponent implements OnInit {

  svi: IzlazakIspit[]=[];
  id: number;
  prosek;
  bodovi;


  constructor(
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.studentService.getPolozio(this.id).subscribe((p: IzlazakIspit[]) => {
            console.log(p);
            let total = 0;
            let b = 0;

            this.svi = p;

            for(let i=0; i<this.svi.length; i++){
                total += this.svi[i].ocena;
                b += this.svi[i].espb;
                console.log(b);
            }

            this.prosek = total / this.svi.length;
            this.bodovi = b;
          });
         }
    });

  }

}
