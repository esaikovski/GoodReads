import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from "./shared/views/home/home.component";
import {RouterModule, Routes} from "@angular/router";
import {RegistrationComponent} from "./shared/views/registration/registration.component";
import { SigninComponent } from './shared/views/signin/signin.component';
import {SignedinComponent} from "./shared/views/signedin/signedin.component";

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'home', component:HomeComponent},
  {path:'register', component:RegistrationComponent},
  {path:'sign_in', component:SigninComponent},
  {path:'signed_in', component:SignedinComponent}
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
