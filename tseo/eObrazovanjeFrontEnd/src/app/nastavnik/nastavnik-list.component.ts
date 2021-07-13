import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../_model/nastavnik';
import { NastavnikService } from '../_service/nastavnik.service';

@Component({
  selector: 'app-nastavnik-list',
  templateUrl: './nastavnik-list.component.html',
  styleUrls: ['./nastavnik-list.component.css']
})
export class NastavnikListComponent implements OnInit {

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
