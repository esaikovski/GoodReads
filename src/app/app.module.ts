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
import { SignedinComponent } from './shared/views/signedin/signedin.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserSettingsComponent } from './shared/views/user-settings/user-settings.component';

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
    ReactiveFormsModule,
    NgbModule,
    BrowserAnimationsModule, //Required for handling the forms
    SignedinComponent,
    UserSettingsComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
