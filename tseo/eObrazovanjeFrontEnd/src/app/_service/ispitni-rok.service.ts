import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IspitniRok } from '../_model/ispitni-rok.model';

@Injectable({
  providedIn: 'root'
})
export class IspitniRokService {

  constructor(private http: HttpClient) { }

  private baseURL = "/api/ispitni-rok"

  getAll(){
    return this.http.get<IspitniRok[]>(this.baseURL);
  }

  getOne(id: number){
    return this.http.get<IspitniRok>(this.baseURL + '/'+id);
  }

  add(rok: IspitniRok){
    return this.http.post(this.baseURL, rok);
  }

  edit(rok: IspitniRok, id: number){
    return this.http.put(this.baseURL + '/' + id, rok);
  }

  delete(id: number){
    return this.http.delete(this.baseURL + '/' + id);
  }


}
