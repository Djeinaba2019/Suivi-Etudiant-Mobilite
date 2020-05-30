import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EcolePartenaireService {

  private baseUrl= 'http://localhost:8080/Suivi-Etudiants/ecole';

  constructor(private http : HttpClient) { }

  getEcolePartenaireById(id:number):Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getAllEcolePartenaire():Observable<any> {
    return this.http.get(`http://localhost:8080/Suivi-Etudiants/ecole/all`);
  }

  createEcolePartenaire(ecole : Object): Observable<Object>{
    return this.http.post(`http://localhost:8080/Suivi-Etudiants/ecole/add`,ecole);

  }

  deleteEcoleById(id : number) : Observable<Object>{
    return this.http.delete(`${this.baseUrl}/${id}`);
  }


}
