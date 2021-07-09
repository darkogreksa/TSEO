import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {TabsModule} from 'ngx-bootstrap/tabs';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {PaginationModule} from 'ngx-bootstrap/pagination';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import { NastavnikService } from './service/nastavnik.service';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { PredmetComponent } from './predmet/predmet.component';
import { PrijavaIspitaComponent } from './prijava-ispita/prijava-ispita.component';
import { IspitComponent } from './ispit/ispit.component';
import { StudentService } from './service/student.service';
import { HomeComponent } from './home/home.component';
import { NastavnikStranicaComponent } from './home/nastavnik-stranica/nastavnik-stranica.component';
import { StudentComponent } from './student/student.component';
import { NastavnikAddComponent } from './nastavnik/nastavnik-add/nastavnik-add.component';
import { NastavnikEditComponent } from './nastavnik/nastavnik-edit/nastavnik-edit.component';
import { AddStudentComponent } from './student/add-student/add-student.component';
import { DokumentComponent } from './student/dokument/dokument.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { PohadjanjePredmetaComponent } from './student/pohadjanje-predmeta/pohadjanje-predmeta.component';
import { PolozeniIspitiComponent } from './student/polozeni-ispiti/polozeni-ispiti.component';
import { StudentProfilComponent } from './student/student-profil/student-profil.component';
import { UplateComponent } from './student/uplate/uplate.component';

@NgModule({
  declarations: [
    AppComponent,
    NastavnikComponent,
    PredmetComponent,
    PrijavaIspitaComponent,
    IspitComponent,
    HomeComponent,
    NastavnikStranicaComponent,
    StudentComponent,
    NastavnikAddComponent,
    NastavnikEditComponent,
    AddStudentComponent,
    DokumentComponent,
    EditStudentComponent,
    PohadjanjePredmetaComponent,
    PolozeniIspitiComponent,
    StudentProfilComponent,
    UplateComponent
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
    BsDatepickerModule.forRoot()
  ],
  providers: [NastavnikService, StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
