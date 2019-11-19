import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-userhistory',
  templateUrl: './userhistory.component.html',
  styleUrls: ['./userhistory.component.css']
})
export class UserhistoryComponent implements OnInit {

  userHistoryArray: [];
  constructor(public productService: ProductService) {
    this.history();
  }
  history() {
    this.productService. getUserHistoryData().subscribe((data) => {
      console.log(data.orderList);
      this.userHistoryArray = data.orderList;
    });
  }

  ngOnInit() {
  }

}
