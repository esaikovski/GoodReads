import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {StorageService} from "../../services/storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  //Definition of variables used during login process
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  submitted = false;
  //roles: string[] = [];

  //Definition of form group fields
  form: FormGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private storageService: StorageService, private router: Router) {
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  //Form validators, can be changed as needed
  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      //this.roles = this.storageService.getUser().roles;
    }
  }

  //Sing-in button modification
  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

    const {username, password} = this.form.value;

    this.authService.login(username, password).subscribe({
      next: data => {
        //this.storageService.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        //this.roles = this.storageService.getUser().roles;

      },
      //Declaration of error message if any error present
      error: err => {
        this.errorMessage = err.error;
        this.isLoginFailed = true;
      },
      complete: () => {
      if(this.isLoggedIn){
      this.router.navigate(['/signed_in']).then(()=> window.location.reload());
      }
    }
    })
  }

}
