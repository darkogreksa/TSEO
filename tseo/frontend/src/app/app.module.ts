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

@NgModule({
  declarations: [
    AppComponent,
    NastavnikComponent
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
  providers: [NastavnikService],
  bootstrap: [AppComponent]
})
export class AppModule { }
