import { DokumentaComponent } from "./student/dokumenta/dokumenta.component";
import { UplateComponent } from "./student/uplate/uplate.component";
import { StudentProfilComponent } from "./student/student-profil/student-profil.component";
import { PohadjanjePredmetaComponent } from "./student/pohadjanje-predmeta/pohadjanje-predmeta.component";
import { PolozeniIspitiComponent } from "./student/polozeni-ispiti/polozeni-ispiti.component";
import { AddStudentComponent } from "./student/add-student/add-student.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { StudentComponent } from "./student/student.component";
import { PredmetiZaUpisComponent } from "./nastavnik/predmeti-za-upis/predmeti-za-upis.component";
import { EditStudentComponent } from "./student/edit-student/edit-student.component";
import { NastavnikListComponent } from "./nastavnik/nastavnik-list.component";
import { AddNastavnikComponent } from "./nastavnik/add-nastavnik/add-nastavnik.component";
import { EditNastavnikComponent } from "./nastavnik/edit-nastavnik/edit-nastavnik.component";
import { UpisOcenaComponent } from "./nastavnik/upis-ocena/upis-ocena.component";
import { LoginComponent } from "./login/login.component";
import { PrijavaIspitaComponent } from "./prijava-ispita/prijava-ispita.component";
import { HomeComponent } from "./home/home.component";
import { NastavnikStranicaComponent } from "./home/nastavnik-stranica/nastavnik-stranica.component";
import { AdminComponent } from "./admin/admin.component";
import { AddPredemetComponent } from "./predmet/add-predemet/add-predemet.component";
import { AddIspitComponent } from "./ispit/add-ispit/add-ispit.component";
import { AdminGuard } from "./_service/security/admin.guard";
import { StudentGuard } from "./_service/security/student.guard";
import { LogOutGuard } from "./_service/security/log-out.guard";
import { NotFoundComponent } from "./not-found/not-found.component";
import { NastavnikGuard } from "./_service/security/nastavnik.guard";

const routes: Routes = [
  {
    path: "student",
    component: StudentComponent,
    pathMatch: "full",
    canActivate: [AdminGuard]
  },
  {
    path: "student/add",
    component: AddStudentComponent,
    pathMatch: "full",
    canActivate: [AdminGuard]
  },
  {
    path: "student/:id",
    component: EditStudentComponent,
    pathMatch: "full",
    canActivate: [AdminGuard]
  },
  {
    path: "polozio/:id",
    component: PolozeniIspitiComponent,
    pathMatch: "full",
    canActivate: [StudentGuard]
  },
  {
    path: "pohadja/:id",
    component: PohadjanjePredmetaComponent,
    pathMatch: "full",
    canActivate: [StudentGuard]
  },
  {
    path: "student-profil/:id",
    component: StudentProfilComponent,
    pathMatch: "full",
    canActivate: [StudentGuard]
  },
  {
    path: "uplate/student/:id",
    component: UplateComponent,
    pathMatch: "full",
    canActivate: [AdminGuard]
  },
  {
    path: "dokumenta/student/:id",
    component: DokumentaComponent,
    pathMatch: "full",
    canActivate: [StudentGuard]
  },
  {
    path: "nastavnik/upis/:nastavnikId",
    component: PredmetiZaUpisComponent,
    canActivate: [NastavnikGuard]
  },
  {
    path: "nastavnik",
    component: NastavnikListComponent,
    canActivate: [AdminGuard]
  },
  {
    path: "nastavnik/add",
    component: AddNastavnikComponent,
    canActivate: [AdminGuard]
  },
  {
    path: "nastavnik/:id",
    component: EditNastavnikComponent,
    canActivate: [NastavnikGuard]
  },
  {
    path: "upis/ispit/:id",
    component: UpisOcenaComponent,
    canActivate: [NastavnikGuard]
  },
  {
    path: "login",
    component: LoginComponent,
    canActivate: [LogOutGuard]
  },
  {
    path: "nastavnik-stranica",
    component: NastavnikStranicaComponent,
    canActivate: [NastavnikGuard]
  },
  {
    path: "nastavnik-stranica/:id",
    component: NastavnikStranicaComponent,
    canActivate: [NastavnikGuard]
  },
  {
    path: "prijava-ispita",
    component: PrijavaIspitaComponent,
    canActivate: [StudentGuard]
  },
  {
    path: "admin",
    component: AdminComponent,
    canActivate: [AdminGuard]
  },
  {
    path: "predmet/add",
    component: AddPredemetComponent,
    canActivate: [AdminGuard]
  },
  {
    path: "ispit/add",
    component: AddIspitComponent,
    canActivate: [AdminGuard]
  },
  { path: "?", component: NotFoundComponent },
  { path: "**", redirectTo: "/%3F" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
