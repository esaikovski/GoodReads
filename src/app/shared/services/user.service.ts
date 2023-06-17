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

  //Method to get user data by username from the API server
  public getUserByUsername(username: string): Observable<UserEntity[]>{
    return this.http.get<UserEntity[]>(`${this.apiServerUrl}user/find/username/${username}`);
  }

  //Method to update user's details on the API server
  public updateUser(id: number, updatedFields: Partial<UserEntity>): Observable<UserEntity> {
    return this.http.patch<UserEntity>(`${this.apiServerUrl}user/update/${id}`, updatedFields);
  }

  //Method to delete a user on the API server by id
  public deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}user/delete/${id}`);
  }

}
