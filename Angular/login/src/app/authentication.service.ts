import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  

  constructor(private http: HttpClient) { }

  getUserDetails(username, password) {
    // post these details to API server, return user info if correct
    let url = '/api/';
    return this.http.post(url);
  }
}
