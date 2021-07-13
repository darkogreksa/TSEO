import { Uplate } from './../../_model/uplate.model';
import { UplateService } from './../../_service/uplate.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-uplate',
  templateUrl: './uplate.component.html',
  styleUrls: ['./uplate.component.css']
})
export class UplateComponent implements OnInit {

  uplate: Uplate[];
  id:number;
  

  constructor(
    private uplateService: UplateService,
    private router: Router,
    private route: ActivatedRoute,
    ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
        if (this.id) {
          this.uplateService.getByStudentId(this.id).subscribe((u: any) => {
            console.log(u);
            if (u) {
              this.uplate = u;
            }
          });
         }
    });
  }

}
