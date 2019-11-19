import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-userproduct',
  templateUrl: './userproduct.component.html',
  styleUrls: ['./userproduct.component.css']
})
export class UserproductComponent implements OnInit {
  selectedProduct: Product = {
    productId: null,
    productCategory: null,
    productName: null,
    productPrice: null,
    productQuantity: null,
 };
 notValid: any;
  productarray: [];
  constructor(public productService: ProductService) {
    this.product();
  }
  product() {
    this.productService.getData().subscribe((data) => {
      console.log(data.productList);
      this.productarray = data.productList;
    });
  }
  selectProduct(product: Product) {
    this.selectedProduct = product;
  }
  addForm(addtocart: NgForm) {
    this.productService.putAddToCart(addtocart.value).subscribe(response => {
      this.notValid = response;
      console.log(response);
      addtocart.reset();

    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
