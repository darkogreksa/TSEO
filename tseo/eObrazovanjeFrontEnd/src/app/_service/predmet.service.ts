import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Predmet } from "../_model/predmet.model";
import { IspitiZaPrijavu } from "../_model/ispiti-za-prijavu.model";
import { Observable } from "rxjs";
import { IspitniRok } from '../_model/ispitni-rok.model';
import { PredmetZaNastavnika } from '../_model/predmet-za-nastavnika.model';

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

  addPredmet(predmet): any {
    return this.http.post(this.baseURL + "/add", predmet);
  }

  obrisiPredmet(id) {
    return this.http.delete(this.baseURL + "delete/" + id);
  }

  getAllByNastavnik(nastavnikId: number) {
    return this.http.get<PredmetZaNastavnika[]>(this.baseURL + "nastavnik/" + nastavnikId);
  }
}
