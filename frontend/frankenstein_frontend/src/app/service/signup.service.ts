import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { AuthUser } from '../model/authuser.model';
import { Config } from '../common/config';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient, @Inject("CONF") private readonly config: Config) { }

  createUser(name: string, password: string){
    const authData: AuthUser = {name, password}
    return this.http.post(this.config.baseUrl() + "user/signup", authData).subscribe((data) => { console.log(data); }, (error) => { console.error(error); });
  }
}
