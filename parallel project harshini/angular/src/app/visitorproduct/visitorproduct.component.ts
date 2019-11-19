import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-visitorproduct',
  templateUrl: './visitorproduct.component.html',
  styleUrls: ['./visitorproduct.component.css']
})
export class VisitorproductComponent implements OnInit {

  productarray: [];

  constructor(public productService: ProductService) {
    this.productService.getData().subscribe((data) => {
      console.log(data.productList);
      this.productarray = data.productList;
    });
  }

  ngOnInit() {
  }

}
