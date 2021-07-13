import { Component, OnInit, Input } from "@angular/core";
import { IspitService } from "../_service/ispit.service";

@Component({
  selector: "app-ispit",
  templateUrl: "./ispit.component.html",
  styleUrls: ["./ispit.component.css"]
})
export class IspitComponent implements OnInit {
  @Input() ispiti;
  ispitPage = { size: null };
  currentPage;
  itemsPerPage;

  constructor(private ispitService: IspitService) {}

  ngOnInit() {
    this.getPredmetPage(0, 6);
  }

  getPredmetPage(page: number, size: number) {
    this.ispitService.getAllPage(page, size).subscribe(page => {
      this.ispitPage = page;
      this.ispiti = page.content;
    });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getPredmetPage(this.currentPage - 1, this.itemsPerPage);
  }
  obrisiIspit(id) {
    this.ispitService.deleteIspit(id).subscribe(res => {
      this.ispiti = this.ispiti.filter(i => i.id != id);
    });
  }
}
