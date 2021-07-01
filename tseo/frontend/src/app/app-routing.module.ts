import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { PrijavaIspitaComponent } from './prijava-ispita/prijava-ispita.component';

const routes: Routes = [
  {
  path: "nastavnik",
  component: NastavnikComponent
},
{
  path: "prijava-ispita",
  component: PrijavaIspitaComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
