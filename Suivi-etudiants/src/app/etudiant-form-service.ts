import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'
import { EtabliPartenaire } from './etabli-partenaire';
@Injectable({
    providedIn: 'root'
  })
  
export class EtudiantFormService {
    private etudUrl = 'http://localhost:8080/esp-template-spring/etudiant/add';
    private depUrl = 'http://localhost:8080/esp-template-spring/departement/all';
    private typeMobUrl = 'http://localhost:8080/esp-template-spring/typeMobilite/all';
    private ecoleUrl = 'http://localhost:8080/esp-template-spring/ecole/all';
    private ecole1Url = 'http://localhost:8080/esp-template-spring/ecole/';
    
    
    constructor(private http: HttpClient) { }

    createEtudiant(etudiant: Object): Observable<Object> {
      return this.http.post(`${this.etudUrl}`, etudiant);   
}
    getDepartementList(): Observable<any> {
    return this.http.get(`${this.depUrl}`);
  }
    getEcoleList(): Observable<any> {
    return this.http.get(`${this.ecoleUrl}`);
  }
    getTypeMobiliteList(): Observable<any> {
    return this.http.get(`${this.typeMobUrl}`);
  }
  getEcole(id: number): Observable<any> {
    return this.http.get(`${this.ecole1Url}/${id}`);
  }
  
}
