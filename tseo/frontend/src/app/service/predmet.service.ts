import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Predmet } from "../model/predmet";
import { IspitiZaPrijavu } from "../model/ispiti-za-prijavu";
import { Observable } from "rxjs";
import { IspitniRok } from '../model/ispitni-rok';
import { PredmetZaNastavnika } from '../model/predmet-za-nastavnika';

@Injectable({
  providedIn: "root"
})
export class PredmetService {
  constructor(private http: HttpClient) {}

  private baseURL = "/api/predmet/";

  getAll() {
    // const url = `${this.baseURL}`;
    // return this.http.get<Predmet[]>(url).pipe();
    return this.http.get<Predmet[]>("api/predmet/all");
  }

  getAllPage(page: number, itemsPerPage: number): Observable<any> {
    return this.http.get(this.baseURL + "/" + page + "/" + itemsPerPage);
  }

  getNepolozeni(student: string, rok: number) {
    return this.http.get<IspitiZaPrijavu[]>("/api/izlazak/student/"+student+"/nepolozeno/"+rok);
  }

  addPredmet(predmet: Predmet): any {
    return this.http.post(this.baseURL + "/add", predmet);
  }

  obrisiPredmet(id : Predmet) {
    return this.http.delete(this.baseURL + "delete/" + id);
  }

  getAllByNastavnik(nastavnikId: number) {
    return this.http.get<PredmetZaNastavnika[]>(this.baseURL + "nastavnik/" + nastavnikId);
  }
}
