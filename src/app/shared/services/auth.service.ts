import {Injectable} from '@angular/core';
import {environment} from "../../environments/environments";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

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
/*
  register(user): Observable<any>{
    return this.http.post(apiServerUrl + 'register', {
      email: user.email,
      password: user.password
    }, httpOptions);
  }
*/
}
