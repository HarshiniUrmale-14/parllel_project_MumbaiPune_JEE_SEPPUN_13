import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Cart } from '../cart';

@Component({
  selector: 'app-viewcart',
  templateUrl: './viewcart.component.html',
  styleUrls: ['./viewcart.component.css']
})
export class ViewcartComponent implements OnInit {

  cartArray: [];


  constructor(public productService: ProductService) {
    this.cart();
  }
  cart() {
    this.productService.getCartData().subscribe((data) => {
      console.log(data.cartList);
      this.cartArray = data.cartList;
    });
  }

  deleteProduct(cart: Cart) {
    this.productService.deleteCartProductData(cart).subscribe(response => {
      console.log(response);
      console.log('deleteproduct');
      this.productService.getData();
      this.cart();
    },
      err => {
        console.log(err);
      });
  }

  ngOnInit() {
  }

}
