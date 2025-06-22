import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule } from '@angular/forms';
import {MatRadioModule} from '@angular/material/radio';
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from '@angular/material/grid-list';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationService } from './service/registration.service';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatIconModule} from '@angular/material/icon';
import { CustomerLoginComponent } from './components/customer-login/customer-login.component';
import { BankManagerLoginComponent } from './components/bank-manager-login/bank-manager-login.component';
import { GetRegComponent } from './components/get-reg/get-reg.component';
import {MatTableModule} from '@angular/material/table';
import { AdminComponent } from './components/admin/admin.component';


@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HomeComponent,
    NavbarComponent,
    CustomerLoginComponent,
    BankManagerLoginComponent,
    GetRegComponent,
    AdminComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatRadioModule,
    MatButtonModule,
    MatGridListModule,
    HttpClientModule,
    MatSnackBarModule,
    MatIconModule,
    MatTableModule
  ],
  providers: [RegistrationService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
