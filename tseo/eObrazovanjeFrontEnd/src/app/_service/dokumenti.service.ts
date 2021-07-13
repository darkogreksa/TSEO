import { DomSanitizer } from '@angular/platform-browser';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DokumentiService {
  private baseUrl = "/api/dokument"


  constructor(
    private http: HttpClient,
    private sanitizer:DomSanitizer

  ) { }

  
  getDokumentByStudentId(id: number){
    return this.http.get(this.baseUrl + "/student/" + id);
  }

  downloadFile(data) {
    const REQUEST_PARAMS = new HttpParams().set('fileName', data.fileName);
    const REQUEST_URL = this.baseUrl + "/download/" + data;
    return this.http.get(REQUEST_URL, {
      params: REQUEST_PARAMS,
      responseType: 'arraybuffer'
    });
  }
}
