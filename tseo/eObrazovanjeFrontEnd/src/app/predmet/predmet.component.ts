import { Component, OnInit, Input } from "@angular/core";
import { PredmetService } from "../_service/predmet.service";

@Component({
  selector: "app-predmet",
  templateUrl: "./predmet.component.html",
  styleUrls: ["./predmet.component.css"]
})
export class PredmetComponent implements OnInit {
  @Input() predmeti;
  currentPage;
  predmetPage = { size: null };
  itemsPerPage;
  constructor(private predmetService: PredmetService) {}

  ngOnInit() {
    this.getPredmetPage(0, 6);
  }

  getPredmetPage(page: number, size: number) {
    this.predmetService.getAllPage(page, size).subscribe(page => {
      this.predmetPage = page;
      this.predmeti = page.content;
    });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getPredmetPage(this.currentPage - 1, this.itemsPerPage);
  }

  obrisiPredmet(id) {
    this.predmetService.obrisiPredmet(id).subscribe(res => {
      this.predmeti = this.predmeti.filter(p => p.id != id);
    });
  }
}
