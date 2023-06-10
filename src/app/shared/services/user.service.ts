import {Injectable} from "@angular/core";
import {environment} from "../../environments/environments";
import {HttpClient} from "@angular/common/http";
import {UserEntity} from "../models/user.entity";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class UserService {
  //Definition of API server base URL
  private apiServerUrl = environment.apiBaseUrl;

  //Inject HttpClient in the constructor
  constructor(private http:HttpClient) { }

  //Method to add new user to the API server
 public addUser(user: UserEntity): Observable<UserEntity>{
    return this.http.post<UserEntity>(`${this.apiServerUrl}/user/add`, user)
 }
}
