import {Injectable} from '@angular/core';
import {environment} from "../../environments/environments";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

//This service sends registration, login, logout HTTP POST requests to back-end.

const httpOptions= {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  //Definition of API server base URL
  private apiServerUrl = environment.apiBaseUrl;

  //Inject HttpClient in the constructor
  constructor(private http:HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      this.apiServerUrl + 'api/auth/login',
      {
        username,
        password,
      },
      httpOptions
    );
  }

  register(username: string, fullName: string, email: string, password: string): Observable<any> {
    return this.http.post(
      this.apiServerUrl + 'api/auth/register',
      {
        username,
        fullName,
        email,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(this.apiServerUrl + 'signout', { }, httpOptions);
  }
}
