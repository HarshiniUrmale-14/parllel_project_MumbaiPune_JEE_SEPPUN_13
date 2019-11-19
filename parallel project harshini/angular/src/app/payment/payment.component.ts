import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  bill: number;


  constructor(public productService: ProductService) {
    this.productService.getPlaceOrderData().subscribe(response => {
      this.bill = response.bill;
    },
      err => {
        console.log(err);
      });

  }

  ngOnInit() {

  }





}
