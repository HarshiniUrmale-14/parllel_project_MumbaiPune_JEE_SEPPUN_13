import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: string = null;
  notValid: any;

  constructor(private auth: AuthService, private router: Router) { }

  login(loginForm: NgForm) {
    this.error = null;
    console.log(loginForm.value);
    this.auth.login(loginForm.value).subscribe(response => {
      this.notValid = response.description;
      console.log(response);
      loginForm.reset();
      if (response.statusCode === 200) {
        const user = JSON.stringify(response);
        localStorage.setItem('value', user);
        if (response.role === 'user') {
          this.router.navigateByUrl('/userpage');
        } else {
          this.router.navigateByUrl('/adminpage');
        }


      }
    }, err => {
      console.log(err);

      loginForm.reset();
    });
  }

  ngOnInit() {
  }

}
