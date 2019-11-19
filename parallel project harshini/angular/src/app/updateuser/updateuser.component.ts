import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {
  user: User;
  idUpdate: any;

  constructor(public productService: ProductService) {
    this.getProfile();
  }

  getProfile() {
    this.productService.getUserProfileData().subscribe((data) => {
      console.log(data.loginBean);
      this.user = data.loginBean;
    });
  }

  updateProfile(updateForm: NgForm) {
    this.productService.putUserProfileData(updateForm.value).subscribe(response => {
      console.log(response);
      this.idUpdate = response;
      updateForm.reset();

    }, err => {
      console.log(err);
    });

  }


  ngOnInit() {
  }

}
