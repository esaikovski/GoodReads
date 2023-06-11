import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import Validation from "./validation";
import {AuthService} from "../../services/auth.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  //Definition of variables used during registration/authentication process
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  //Definition of form group fields
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    fullName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl(''),
  });
  submitted = false;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
  }

  //Form validators, can be changed as needed
  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        username: ['', Validators.required],
        fullName: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(40)
          ]
        ],
        confirmPassword: ['', Validators.required],
      },
      {
        validators: [Validation.match('password', 'confirmPassword')]
      }
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  //Register button modification
  onSubmit(): void {

    this.submitted = true;

    if (this.form.invalid) {
      return;
    }
    const {username, fullName, email, password} = this.form.value;

    this.authService.register(username, fullName, email, password).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      //Declaration of error message if any error present
      error: err => {
        this.errorMessage = err.error;
        this.isSignUpFailed = true;
      }
    })
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }

}
