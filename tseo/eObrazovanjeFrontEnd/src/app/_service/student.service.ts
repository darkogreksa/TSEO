import { pipe } from "rxjs";
import { IzlazakIspit } from "src/app/_model/izlazakIspit.model";
import { HttpRequest } from "@angular/common/http";
import { HttpEvent } from "@angular/common/http";
import { Student } from "./../_model/student";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class StudentService {
  private baseUrl = "/api/student";

  constructor(private http: HttpClient) {}

  getAll(): Observable<Student[]> {
    const url = `${this.baseUrl}`;
    return this.http.get<Student[]>(url).pipe();
  }

  getId(id: number): Observable<Student> {
    const url = `${this.baseUrl}/` + id;
    return this.http.get<Student>(url);
  }

  add(student: any) {
    console.log(student);
    return this.http.post<Student>(this.baseUrl, student);
  }

  edit(student: Student) {
    return this.http.put(this.baseUrl, student);
  }

  delete(id: number) {
    return this.http.delete(this.baseUrl + "/" + id);
  }

  getAllPaged(page: number, itemsPerPage: number): Observable<any> {
    return this.http.get(this.baseUrl + "/" + page + "/" + itemsPerPage);
  }

  getByName(name: string): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl + "/ime/" + name);
  }

  getPolozio(id: number) {
    return this.http.get(this.baseUrl + "/polozio/" + id);
  }

  getPohadja(id: number) {
    return this.http.get(this.baseUrl + "/pohadja/" + id);
  }

  getNepolozeni(id: number) {
    return this.http.get(this.baseUrl + "/nepolozeni/" + id);
  }

  getIzlasci() {
    return this.http.get("api/izlazak/all");
  }

  prijavi(ispitId, studentId) {
    return this.http.post("/api/izlazak/" + studentId + "/" + ispitId, {});
  }

  getPrijava(id: number) {
    return this.http.get("/api/izlazak/student/" + id);
  }

  uploadFile(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append("file", file);
    const req = new HttpRequest(
      "POST",
      "http://localhost:8080/api/dokument/upload",
      formdata,
      {
        reportProgress: true,
        responseType: "text"
      }
    );

    return this.http.request(req);
  }
}
