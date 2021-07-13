import { UplateComponent } from "./student/uplate/uplate.component";
import { StudentService } from "./_service/student.service";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { StudentComponent } from "./student/student.component";
import { from } from "rxjs";
import { NastavnikService } from "./_service/nastavnik.service";
import { PredmetiZaUpisComponent } from "./nastavnik/predmeti-za-upis/predmeti-za-upis.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {
  BsDropdownModule,
  TabsModule,
  BsDatepickerModule,
  PaginationModule,
  ButtonsModule
} from "ngx-bootstrap";
import { AddStudentComponent } from "./student/add-student/add-student.component";
import { EditStudentComponent } from "./student/edit-student/edit-student.component";
import { PolozeniIspitiComponent } from "./student/polozeni-ispiti/polozeni-ispiti.component";
import { NastavnikListComponent } from "./nastavnik/nastavnik-list.component";
import { AddNastavnikComponent } from "./nastavnik/add-nastavnik/add-nastavnik.component";
import { EditNastavnikComponent } from "./nastavnik/edit-nastavnik/edit-nastavnik.component";
import { UpisOcenaComponent } from "./nastavnik/upis-ocena/upis-ocena.component";
import { LoginComponent } from "./login/login.component";
import { PohadjanjePredmetaComponent } from "./student/pohadjanje-predmeta/pohadjanje-predmeta.component";
import { NavComponent } from "./partials/nav/nav.component";
import { PrijavaIspitaComponent } from "./prijava-ispita/prijava-ispita.component";
import { StudentProfilComponent } from "./student/student-profil/student-profil.component";
import { DokumentaComponent } from "./student/dokumenta/dokumenta.component";
import { HomeComponent } from "./home/home.component";
import { NastavnikStranicaComponent } from "./home/nastavnik-stranica/nastavnik-stranica.component";
import { AdminComponent } from "./admin/admin.component";
import { PredmetComponent } from "./predmet/predmet.component";
import { AddPredemetComponent } from "./predmet/add-predemet/add-predemet.component";
import { IspitComponent } from "./ispit/ispit.component";
import { AddIspitComponent } from "./ispit/add-ispit/add-ispit.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { UplateStudentuComponent } from "./uplate-studentu/uplate-studentu.component";
import { AutocompleteLibModule } from "angular-ng-autocomplete";
import { NotFoundComponent } from './not-found/not-found.component';
// import { PrijavaIspitaComponent } from './student/prijava-ispita/prijava-ispita.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    PredmetiZaUpisComponent,
    AddStudentComponent,
    EditStudentComponent,
    PolozeniIspitiComponent,
    NastavnikListComponent,
    AddNastavnikComponent,
    EditNastavnikComponent,
    UpisOcenaComponent,
    LoginComponent,
    PohadjanjePredmetaComponent,
    NavComponent,
    StudentProfilComponent,
    PrijavaIspitaComponent,
    UplateComponent,
    DokumentaComponent,
    HomeComponent,
    NastavnikStranicaComponent,
    AdminComponent,
    PredmetComponent,
    AddPredemetComponent,
    IspitComponent,
    AddIspitComponent,
    NavbarComponent,
    UplateStudentuComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    TabsModule.forRoot(),
    BsDropdownModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot(),
    AutocompleteLibModule
  ],
  providers: [StudentService, NastavnikService],
  bootstrap: [AppComponent]
})
export class AppModule {}
