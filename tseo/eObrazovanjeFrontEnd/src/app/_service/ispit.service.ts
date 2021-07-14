import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { IspitZaNastavnika } from '../_model/ispit-za-nastavnika.model';

@Injectable({
  providedIn: "root"
})
export class IspitService {
  
  constructor(private http: HttpClient) {}

  private baseURL = "/api/ispit/";

  getAll() {
    return this.http.get(this.baseURL + "/all");
  }
  getAllPage(page: number, itemsPerPage: number): Observable<any> {
    return this.http.get(this.baseURL + "/" + page + "/" + itemsPerPage);
  }

  addIspit(ispit) {
    return this.http.post(this.baseURL + "/add", ispit);
  }

  deleteIspit(id) {
    return this.http.delete(this.baseURL + "delete/" + id);
  }

  getAllByNastavnik(nastavnikId: number) {
    return this.http.get<IspitZaNastavnika[]>(this.baseURL + "nastavnik/" + nastavnikId);
  }

  getAllKolokvijumiByNastavnik(nastavnikId: number) {
    return this.http.get<IspitZaNastavnika[]>(this.baseURL + "kolokvijum/nastavnik/" + nastavnikId);
  }
}
