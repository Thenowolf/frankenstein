import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthUser } from '../model/authuser.model';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }

  createUser(name: string, password: string){
    const authData: AuthUser = {name, password}
    console.log("aha");
    return this.http.post("http://localhost:8080/api/user/signup", authData).subscribe((data) => { console.log(data); }, (error) => { console.error(error); });
  }
}
