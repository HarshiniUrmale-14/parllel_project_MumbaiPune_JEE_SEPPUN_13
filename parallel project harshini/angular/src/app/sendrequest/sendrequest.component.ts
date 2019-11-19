import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-sendrequest',
  templateUrl: './sendrequest.component.html',
  styleUrls: ['./sendrequest.component.css']
})
export class SendrequestComponent implements OnInit {
  messageArray: [];
  inMsg: any;

  constructor(private productService: ProductService) {
    this.message();
  }
  message() {
    this.productService.getAdminReplyData().subscribe((data) => {
      console.log(data.replyList);
      this.messageArray = data.replyList;
    });
  }
  sendMessage(sendForm: NgForm) {
    console.log(sendForm.value);
    this.productService.putUserMessageData(sendForm.value).subscribe(response => {
      console.log(response);
      this.inMsg = response;
      sendForm.reset();
      this.message();
    },
      err => {
        console.log(err);
      }

    );
  }


  ngOnInit() {
  }

}
