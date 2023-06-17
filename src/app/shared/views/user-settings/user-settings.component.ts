import {Component, OnInit} from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule, MatIconRegistry} from "@angular/material/icon";
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";
import {UserEntity} from "../../models/user.entity";
import {UserService} from "../../services/user.service";
import {HttpErrorResponse} from '@angular/common/http';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators
} from "@angular/forms"; // Module for handling HTTP errors
import {NgForm} from '@angular/forms';
import {StorageService} from "../../services/storage.service";
import {AuthService} from "../../services/auth.service";
import {MatInputModule} from "@angular/material/input";
import Validation from "../registration/validation";
import {NgClass, NgIf} from "@angular/common"; // Module for handling forms

const ACCOUNT_ICON =
  `
  <svg xmlns="http://www.w3.org/2000/svg" height="48" viewBox="0 -960 960 960" width="48">
  <path d="M232.001-253.077q59.923-38.461 118.922-58.961 59-20.5 129.077-20.5t129.384 20.5q59.308 20.5 119.231 58.961 43.615-50.538 64.807-106.692Q814.615-415.923 814.615-480q0-141.538-96.538-238.077Q621.538-814.615 480-814.615t-238.077 96.538Q145.385-621.538 145.385-480q0 64.077 21.5 120.231 21.5 56.154 65.116 106.692Zm247.813-204.231q-53.968 0-90.775-36.994-36.808-36.993-36.808-90.961 0-53.967 36.994-90.775 36.993-36.807 90.961-36.807 53.968 0 90.775 36.993 36.808 36.994 36.808 90.961 0 53.968-36.994 90.775-36.993 36.808-90.961 36.808Zm-.219 357.307q-78.915 0-148.39-29.77-69.475-29.769-120.878-81.576-51.403-51.808-80.864-120.802-29.462-68.994-29.462-148.351 0-78.972 29.77-148.159 29.769-69.186 81.576-120.494 51.808-51.307 120.802-81.076 68.994-29.77 148.351-29.77 78.972 0 148.159 29.77 69.186 29.769 120.494 81.076 51.307 51.308 81.076 120.654 29.77 69.345 29.77 148.233 0 79.272-29.77 148.192-29.769 68.919-81.076 120.727-51.308 51.807-120.783 81.576-69.474 29.77-148.775 29.77Z"/></svg>
  `
;

@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css'],
  standalone: true,
  imports: [MatButtonModule, MatMenuModule, MatIconModule, FormsModule, MatInputModule, ReactiveFormsModule, NgClass, NgIf],
})
export class UserSettingsComponent implements OnInit {

  // Array of Users objects to hold user data
  public users: UserEntity[] | undefined | null;

  // User object for editing
  public user: UserEntity | undefined | null;

  // Current user variable which holds username and password from sign-in component
  currentUser: any;

  // Variable to hold error messages
  errorMessage = '';

  // Variable to check if the form is submitted or not
  submitted = false;

  // Variable to check if the form is successfully saved
  isSuccessful = false;

  // Variable to check if the form is successfully saved
  isFormSavingFailed = false;

  //Definition of form group fields
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    fullName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    gender: new FormControl(''),
    address: new FormControl(''),
    aboutMe: new FormControl('')
  });

  // Constructor with required services
  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer, private router: Router,
              private storageService: StorageService, private authservice: AuthService, private userservice: UserService,
              private formBuilder: FormBuilder) {
    iconRegistry.addSvgIconLiteral('thumbs-up', sanitizer.bypassSecurityTrustHtml(ACCOUNT_ICON));
  }

  // Things to happen during the page initialization
  ngOnInit(): void {
    this.currentUser = this.storageService.getUser();
    this.getUser() // Call method to retrieve current user from the back-end server;

    this.form = this.formBuilder.group(
      {
        username: ['', Validators.required],
        fullName: ['',],
        email: ['', [Validators.email]],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(6)
          ]
        ],
        gender: [''],
        address: [''],
        aboutMe: ['']
      },
    );
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }

  //Save button modification, we need to make changes in user service as we need to be able to update only certain fields!
  public onSave(user: UserEntity): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

    // Create a new object with the specific fields you want to update
    const updatedFields: Partial<UserEntity> = {
      id: user.id,
      username: this.form.value.username,
      password: this.form.value.password,
      fullName: this.form.value.fullName,
      email: this.form.value.email,
      gender: this.form.value.gender,
      address: this.form.value.address,
      aboutMe: this.form.value.aboutMe
    };

    this.userservice.updateUser(user.id, updatedFields).subscribe({
      next: (response: UserEntity) => {
        console.log(response);
        //Saves user in browser session storage
        this.storageService.saveUser(this.form.value);
        this.isSuccessful = true;
      },
      //Declaration of error message if any error present
      error: err => {
        this.errorMessage = err.error;
        this.isFormSavingFailed = true;
      }
    });
  }

  public getUser(): void {
    this.userservice.getUserByUsername(this.currentUser.username).subscribe({
        next: (response: UserEntity[]) => {
          this.users = response; // Assign the retrieved user data to the component's user data
          this.user = JSON.parse(JSON.stringify(this.users)); // Initialize the editUser object with a deep copy of users
          console.log(this.users); // Log the user array to the console
        },
        //Declaration of error message if any error present
        error: err => {
          this.errorMessage = err.error;
        },
      }
    )
  }

  //Definition of settings button function
  public onSettings(): void {
    this.router.navigate(['/settings']).then(() => window.location.reload());
  }

  //Definition of sign-out button function
  public onSignout(): void {
    this.router.navigate(['/home']).then(() => window.location.reload());
    this.storageService.clean();
    //Show message to the user
    this.authservice.logout();
  }

  //Definition of delete button function
  public onDelete(): void {
    if (this.user) {
      this.userservice.deleteUser(this.user.id).subscribe({
        next: () => {
          console.log('User deleted successfully');
          this.storageService.clean();
          this.router.navigate(['/home']).then(() => window.location.reload());
        },
        error: (err) => {
          this.errorMessage = err.error;
        }
      });
    }
  }
}
