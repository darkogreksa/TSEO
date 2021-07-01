import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NastavnikComponent } from './nastavnik/nastavnik.component';

const routes: Routes = [
  { path: "/api/nastavnik/all", component: NastavnikComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
