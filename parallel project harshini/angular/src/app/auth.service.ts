import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable
  ({
    providedIn: 'root'
  })

export class AuthService {


  constructor(private http: HttpClient) { }
  isLoggedIn(): boolean {
    const check = JSON.parse(localStorage.getItem('value'));
    if (check && check.statusCode === 200) {
      return true;
    } else {
      return false;
    }
  }


  register(user): Observable<any> {
    return this.http.post(`http://localhost:8080/registration`, user);
  }

  login(data): Observable<any> {
    return this.http.post(`http://localhost:8080/login`, data);
  }
}
