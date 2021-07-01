import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Uplate } from '../model/uplate';

@Injectable({
  providedIn: 'root'
})
export class UplateService {
  private baseUrl = "/api/uplata";

  constructor(private http: HttpClient) {}

  getAll(): Observable<Uplate[]> {
    const url = `${this.baseUrl}/all`;
    return this.http.get<Uplate[]>(url).pipe();
  }

  getByStudentId(id: number): Observable<Uplate[]> {
    return this.http.get<Uplate[]>(this.baseUrl + "/student/" + id).pipe();
  }

  uplataStudentu(uplata: any) {
    return this.http.post(this.baseUrl, uplata);
  }
}
