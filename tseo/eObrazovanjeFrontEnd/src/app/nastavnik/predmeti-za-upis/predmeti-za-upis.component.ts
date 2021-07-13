import { Component, OnInit } from '@angular/core';
import { NastavnikService } from 'src/app/_service/nastavnik.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-predmeti-za-upis',
  templateUrl: './predmeti-za-upis.component.html',
  styleUrls: ['./predmeti-za-upis.component.css']
})
export class PredmetiZaUpisComponent implements OnInit {

  nastavnikId: number;
  predmeti: any[] = [];

  constructor(
    private nastavnikService: NastavnikService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      // poboljsati da se id nastavnika uzima iz nekog servisa za autentifikaciju, ne iz url-a 
      this.nastavnikId = Number.parseInt(params['nastavnikId']);
      this.nastavnikService.getIspitiForUpisOcenaByNastavnikIdAndRokId(this.nastavnikId, 1).subscribe(
        (predmeti: any[]) => {
          this.predmeti = predmeti;
          console.log(predmeti);
        }
      );
    });
  }

}
