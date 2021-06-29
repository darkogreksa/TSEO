import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Nastavnik } from '../model/nastavnik';

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
}
