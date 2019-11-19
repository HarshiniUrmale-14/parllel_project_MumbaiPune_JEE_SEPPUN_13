import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  notValid: any;

  constructor(private productService: ProductService) { }

submit(addForm: NgForm) {
    console.log(addForm.value);
    this.productService.putData(addForm.value).subscribe(response => {
    this.notValid = response;
    console.log(response);
    addForm.reset();
    },
      err => {
        console.log(err);
      }

    );
  }

  ngOnInit() {
  }

}
