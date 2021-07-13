import { Component, OnInit, ViewChild } from "@angular/core";
import { PredmetService } from "src/app/_service/predmet.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-add-predemet",
  templateUrl: "./add-predemet.component.html",
  styleUrls: ["./add-predemet.component.css"]
})
export class AddPredemetComponent implements OnInit {
  predmet = {
    naziv: null,
    espb: null,
    sifraPredmeta: null,
    smer: null
  };
  errorMsg;

  constructor(private predmetService: PredmetService, private router: Router) {}

  @ViewChild("selectSmer") selectSmer = {
    nativeElement: { value: null }
  };
  ngOnInit() {}

  addPredmet() {
    this.predmet.smer = this.selectSmer.nativeElement.value;
    if (
      this.predmet.naziv == null ||
      this.predmet.espb == null ||
      this.predmet.sifraPredmeta == null
    ) {
      this.errorMsg = "Popunite sva polja.";
    } else {
      this.predmetService.addPredmet(this.predmet).subscribe(res => {
        this.router.navigateByUrl("/admin");
      });
    }
  }
}
