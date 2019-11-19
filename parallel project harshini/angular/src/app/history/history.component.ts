import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  orderArray: [];

  constructor(public productService: ProductService) {
    this.productService.getHistoryData().subscribe((data) => {
      console.log(data.orderList);
      this.orderArray = data.orderList;
    });
  }

  ngOnInit() {
  }

}
