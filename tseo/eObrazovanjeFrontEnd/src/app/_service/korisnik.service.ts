import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Korisnik } from '../_model/korisnik.model';

@Injectable({
  providedIn: 'root'
})
export class KorisnikService {

  constructor(private http: HttpClient) { }

  add(korisnik: Korisnik) {
    return this.http.post('/api/korisnik', korisnik);
  }
}
