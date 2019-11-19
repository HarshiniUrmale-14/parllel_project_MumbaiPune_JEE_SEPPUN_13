import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
  })
  export class ProductService {
    api = 'https://localhost:8080/';
  get: any;
    
    constructor(private http: HttpClient) {
}
getProduct() {
     return this.http.get(`${this.api}getProduct`);

    }
}
