import { Component, OnInit, ViewChild, ElementRef } from "@angular/core";
import { StudentService } from "../_service/student.service";
import { UplateService } from "../_service/uplate.service";

@Component({
  selector: "app-uplate-studentu",
  templateUrl: "./uplate-studentu.component.html",
  styleUrls: ["./uplate-studentu.component.css"]
})
export class UplateStudentuComponent implements OnInit {
  constructor(
    private studentService: StudentService,
    private uplataService: UplateService
  ) {}
  studenti;
  keyword = "fullId";
  uplataStudenta = {
    iznos: null,
    datum: null,
    studentDTO: null
  };
  errorMsg;

  ngOnInit() {
    this.studentService.getAll().subscribe(res => {
      this.studenti = res;
      this.studenti.forEach(s => {
        s.fullId = s.ime + " " + s.prezime + " " + s.brIndeksa;
      });
    });
  }

  selectEvent(item) {
    this.uplataStudenta.studentDTO = item;
  }

  uplati() {
    console.log(this.uplataStudenta);
    if (
      this.uplataStudenta.iznos == null ||
      this.uplataStudenta.studentDTO == null
    ) {
      this.errorMsg = "Morate popuniti sva polja";
    } else {
      this.uplataStudenta.datum = new Date();
      this.uplataService.uplataStudentu(this.uplataStudenta).subscribe(res => {
        alert("Uspešno uplaćen novac.");
        this.uplataStudenta.iznos = "";
        this.errorMsg = "";
      });
    }
  }
}
