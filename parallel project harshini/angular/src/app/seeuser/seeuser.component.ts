import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { User } from '../user';


@Component({
  selector: 'app-seeuser',
  templateUrl: './seeuser.component.html',
  styleUrls: ['./seeuser.component.css']
})
export class SeeuserComponent implements OnInit {

  userArray: [];
  constructor(public productService: ProductService) {
    this.userProfile();
  }

  userProfile() {
    this.productService.getUserData().subscribe((data) => {
      console.log(data.loginList);
      this.userArray = data.loginList;
    });
  }

  deleteUser(user: User) {
    this.productService.deleteUserData(user).subscribe(response => {
      console.log(response);
      console.log('deleteuser');
      this.productService.getUserData();
      this.userProfile();
    },
      err => {
        console.log(err);
      });
  }

  ngOnInit() {
  }

}
