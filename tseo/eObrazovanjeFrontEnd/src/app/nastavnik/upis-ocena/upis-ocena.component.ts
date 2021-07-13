import { Component, OnInit } from '@angular/core';
import { NastavnikService } from 'src/app/_service/nastavnik.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-upis-ocena',
  templateUrl: './upis-ocena.component.html',
  styleUrls: ['./upis-ocena.component.css']
})
export class UpisOcenaComponent implements OnInit {
  izlasci: any[];
  id: number;

  constructor(
    private nastavnikService: NastavnikService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      if (this.id) {
        // hardcoded nastavnik id, preuzeti id logovanog nastavnika
        this.nastavnikService.getIzlasciZaUpisByIspitId(this.id)
          .subscribe(izlasci => {this.izlasci = izlasci; console.log(izlasci)});
      }
    });
  }

  oceni(){

  }

}
