import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-seeproduct',
  templateUrl: './seeproduct.component.html',
  styleUrls: ['./seeproduct.component.css']
})
export class SeeproductComponent implements OnInit {
  selectedProduct: Product = {
    productId: null,
    productCategory: null,
    productName: null,
    productPrice: null,
    productQuantity: null,
  };

  update: any;
  delete: any;
  productarray: [];
  constructor(public productService: ProductService) {
    this.getProduct();

  }
  getProduct() {
    this.productService.getData().subscribe((data) => {
      console.log(data.productList);
      this.productarray = data.productList;
    });
  }
  deleteProduct(product: Product) {
    this.productService.deleteData(product).subscribe(response => {
      console.log(response);
      this.delete = response;
      console.log('deleteproduct');
      this.getProduct();
    },
      err => {
        console.log(err);
      });
  }
  selectProduct(product: Product) {
    this.selectedProduct = product;
  }
  submitForm(form: NgForm) {
    this.productService.postData(form.value).subscribe(response => {
      console.log(response);
      this.update = response;
      form.reset();
    }, err => {
      console.log(err);
    });

  }


  ngOnInit() {
  }

}
