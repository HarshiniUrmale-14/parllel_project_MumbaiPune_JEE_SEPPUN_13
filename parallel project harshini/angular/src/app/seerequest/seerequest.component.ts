import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { Message } from '../message';

@Component({
  selector: 'app-seerequest',
  templateUrl: './seerequest.component.html',
  styleUrls: ['./seerequest.component.css']
})
export class SeerequestComponent implements OnInit {
  messageArray: [];
  isMsg: any;
  constructor(public productService: ProductService) {
    this.getMessage();
  }
  getMessage() {
    this.productService.getUserMessageData().subscribe((data) => {
      console.log(data.requestList);
      this.messageArray = data.requestList;
    });
  }

  submitForm(userMessage: NgForm) {
    console.log(userMessage.value);
    this.productService.putAdminReplyData(userMessage.value).subscribe(response => {
      console.log(response);
      this.isMsg = response;
      userMessage.reset();
      this.getMessage();
    },
      err => {
        console.log(err);
      }

    );
  }
  ngOnInit() {
  }

}
