import { FormGroup, FormBuilder } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { StudentService } from "src/app/_service/student.service";


@Component({
  selector: "app-pohadjanje-predmeta",
  templateUrl: "./pohadjanje-predmeta.component.html",
  styleUrls: ["./pohadjanje-predmeta.component.css"]
})
export class PohadjanjePredmetaComponent implements OnInit {
  predmeti: any[];
  editStudentForm: FormGroup;
  id: number;

  constructor(
    private studentService: StudentService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params["id"];
      if (this.id) {
        this.studentService.getNepolozeni(this.id).subscribe((p: any) => {
          console.log("PREDMETTIII:");
          console.log(p);
          this.predmeti = p;
        });
      }
    });
  }
}
