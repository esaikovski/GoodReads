import { Injectable } from '@angular/core';
import {environment} from "../../environments/environments";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  //Definition of API server base URL
  private apiServerUrl = environment.apiBaseUrl;

  //Inject HttpClient in the constructor
  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(this.apiServerUrl + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(this.apiServerUrl + 'user', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(this.apiServerUrl + 'admin', { responseType: 'text' });
  }
}
