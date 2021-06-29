import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/nastavnik';
import { NastavnikService } from '../service/nastavnik.service';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit {

  nastavnici: Nastavnik[];

  constructor(
    private nastavnikService: NastavnikService
  ) { }

  ngOnInit() {
    this.getNastavniks();
  }

  getNastavniks() { // :)
    this.nastavnikService.getAll()
      .subscribe(nastavnici => this.nastavnici = nastavnici);
  }

  delete(id: number) {
    this.nastavnikService.delete(id).subscribe(() => {
      for (let i = 0; i < this.nastavnici.length; i++) {
        if (this.nastavnici[i].id === id) {
          this.nastavnici.splice(i, 1);
        }
      }
    });
  }
}
