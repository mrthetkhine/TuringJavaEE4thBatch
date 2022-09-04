import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
export const API_URL = "http://localhost:8080/login";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authenticated = false;
  token:string = '';
  constructor(private http:HttpClient,
              private router: Router) { }

  loadToken()
  {
    let token = localStorage.getItem("token");
    if(token)
    {
      this.setAuthentication(token);
    }
  }
  isAuthenticated()
  {
    return this.authenticated;
  }
  setAuthentication(token:string)
  {
    this.token = token;
    this.authenticated = true;
  }
  login(username:string,password:string):Observable<any>
  {
    return this.http.post(API_URL,{
      username, //username:username
      password,
    });
  }
  getToken()
  {
    return this.token;
  }
  logout()
  {
    localStorage.removeItem("token");
    this.token = "";
    this.authenticated = false;
    this.router.navigate(["/login"]);
  }
}
