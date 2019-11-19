import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  valid: any;

  constructor(private auth: AuthService, private router: Router) { }

  register(registerForm: NgForm) {
    console.log(registerForm.value);
    this.auth.register(registerForm.value).subscribe(response => {
      this.valid = response.description;
      console.log(response);
      registerForm.reset();
      if (response.statusCode === 200) {
        this.router.navigateByUrl('/');
      }
    }, err => {
      console.log(err);

      registerForm.reset();
    });
  }

  ngOnInit() {
  }

}

