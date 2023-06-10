import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import { HomeComponent } from './shared/views/home/home.component';
import { RegistrationComponent } from './shared/views/registration/registration.component';
import { AppRoutingModule } from './app-routing.module';
import { SigninComponent } from './shared/views/signin/signin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    SigninComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule, //Required for making HTTP requests
    RouterOutlet,
    AppRoutingModule,
    ReactiveFormsModule,//Required for handling the forms
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
