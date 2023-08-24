import { Inject, Injectable, InjectionToken, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './model/user.model';
import { Constants } from './config/constants';
import { Config } from './common/config';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  @Inject('CONF') private config!: Config;

  constructor(private http: HttpClient) { }

  public getUsers(): Observable<User[]>{
    console.log("aaa")
    //console.log(this.config.baseUrl())
    return this.http.get<User[]>("http://localhost:8080" + "/api/user/all")
    //return this.http.get<User[]>(this.config.baseUrl() + "/user/all")
    //console.log(this.config.baseUrl())
  }
}
