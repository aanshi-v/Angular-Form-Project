import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomeComponent } from './components/home/home.component';
import { CustomerLoginComponent } from './components/customer-login/customer-login.component';
import { BankManagerLoginComponent } from './components/bank-manager-login/bank-manager-login.component';
import { GetRegComponent } from './components/get-reg/get-reg.component';
import { AdminComponent } from './components/admin/admin.component';

const routes: Routes = [
  {
    path: "registration",
    component: RegistrationComponent,
    pathMatch: "full"
  },
  {
    path: "home",
    component: HomeComponent,
    pathMatch: "full"
  },
  {
    path:'',
    component:HomeComponent,
    pathMatch: "full"
  },
  {
    path:"customerLogin",
    component: CustomerLoginComponent,
    pathMatch: "full"
  },
  {
    path:"bankManagerLogin",
    component:BankManagerLoginComponent,
    pathMatch: "full"
  },
  {
    path: "getReg",
    component: GetRegComponent,
    pathMatch: "full"
  },
  {
    path: "admin",
    component: AdminComponent,
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
