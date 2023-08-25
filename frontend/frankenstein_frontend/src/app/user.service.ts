import { Inject, Injectable, InjectionToken, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './model/user.model';
import { Config } from './common/config';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //@Inject('CONF') private readonly config: Config;

  constructor(private http: HttpClient, @Inject("CONF") private readonly config: Config) { }

  public getUsers(): Observable<User[]>{
    console.log("aaa")
    //console.log(this.config.baseUrl())
    //return this.http.get<User[]>("http://localhost:8080" + "/api/user/all")
    return this.http.get<User[]>(this.config.baseUrl() + "user/all")
    //console.log(this.config.baseUrl())
  }
}
