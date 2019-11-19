import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './product';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];
  users: User[] = [];
  api = 'http://localhost:8080/';


  constructor(private http: HttpClient) { }
  postData(data) {
    return this.http.post(`${this.api}updateProduct`, data);
  }
  getData() {
    return this.http.get<any>(`${this.api}getProduct`);
  }
  deleteData(data) {
    return this.http.delete(`${this.api}deleteProduct/${data.productId}`);
  }
  putData(data) {
    return this.http.put(`${this.api}addProduct`, data);
  }
  getUserData() {
    return this.http.get<any>(`${this.api}getUser`);
  }
  deleteUserData(data) {
    return this.http.delete(`${this.api}deleteUser/${data.id}`);
  }
  getUserMessageData() {
    return this.http.get<any>(`${this.api}seeRequest`);
  }
  putAdminReplyData(data) {
    return this.http.put(`${this.api}sendReplyToUser`, data);
  }
  putAddToCart(data) {
    return this.http.put(`${this.api}addToCart`, data);
  }
  getCartData() {
    return this.http.get<any>(`${this.api}getCart`);
  }
  deleteCartProductData(data) {
    return this.http.delete(`${this.api}deleteFromCart/${data.cartId}`);
  }
  putUserProfileData(data) {
    return this.http.put(`${this.api}updateUser`, data);
  }
  putUserMessageData(data) {
    return this.http.put(`${this.api}sendRequest`, data);
  }
  getAdminReplyData() {
    return this.http.get<any>(`${this.api}seeReply`);
  }
  getPlaceOrderData() {
    return this.http.get<any>(`${this.api}payment`);
  }
  getHistoryData() {
    return this.http.get<any>(`${this.api}orderHistory`);
  }
  getUserProfileData() {
    return this.http.get<any>(`${this.api}getUserProfile`);
  }
  getUserHistoryData() {
    return this.http.get<any>(`${this.api}userHistory`);
  }
}
