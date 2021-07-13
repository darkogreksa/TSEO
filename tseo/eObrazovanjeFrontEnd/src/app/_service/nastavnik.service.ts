import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Nastavnik } from '../_model/nastavnik';

@Injectable({
  providedIn: 'root'
})
export class NastavnikService {

  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<Nastavnik[]>('/api/nastavnik/all');
  }

  getOne(id: number) {
    return this.http.get<Nastavnik>('/api/nastavnik/' + id);
  }

  add(nastavnik: Nastavnik) {
    return this.http.post('/api/nastavnik', nastavnik);
  }

  edit(nastavnik: Nastavnik) {
    return this.http.put<Nastavnik>('/api/nastavnik', nastavnik);
  }

  delete(id: number) {
    return this.http.delete('/api/nastavnik/' + id);
  }

  getPredmetiByNastavnikId(id: number) {
    return this.http.get<any[]>('/api/predmet/nastavnik/' + id);
  }

  getIspitiForUpisOcenaByNastavnikIdAndRokId(nastavnikId: number, rokId: number) {
    return this.http.get<any[]>('/api/ispit/ocenjivanje/nastavnik/' + nastavnikId + '/rok/' + rokId);
  }

  getIspitiForUpisOcenaByNastavnikId(nastavnikId: number) {
    return this.http.get<any[]>('/api/ispit/ocenjivanje/nastavnik/' + nastavnikId);
  }

  getKolokvijumiForUpisOcenaByNastavnikId(nastavnikId: number) {
    return this.http.get<any[]>('/api/ispit/kolokvijum/nastavnik/' + nastavnikId);
  }

  getIzlasciZaUpisByIspitId(IspitId: number) {
    return this.http.get<any[]>('/api/izlazak/ispit/' + IspitId);
  }

}
