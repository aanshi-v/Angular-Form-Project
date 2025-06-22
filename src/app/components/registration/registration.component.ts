import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RegistrationService } from 'src/app/service/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  data = {
    firstName : "",
    middleName : "",
    lastName : "",
    mobileNo : "",
    emailId : "",
    dateOfBirth : "",
    aadhaarNo : "",
    birthCertificate : "",
    salarySlips : "",
    gstrFiling : ""
  }

  constructor(private regService: RegistrationService, private snak: MatSnackBar ) { }

  ngOnInit(): void {
  }

  radioSelected(event:any){
    console.log(event.value)
    this.data.birthCertificate = event.value
  }

  radioSelected2(event:any){
    console.log(event.value)
    if(event.value == "Yes"){
      this.data.salarySlips = "Y"
      this.data.gstrFiling = "N"
    }
    else{
      this.data.gstrFiling = "Y"
      this.data.salarySlips = "N"
    }
  }

  doSubmitForm(){                                             //created a method to submit the form
    console.log("Try to submit form...")
    console.log(this.data)

    if(this.data.firstName==''  || this.data.lastName=='' || this.data.mobileNo=='' || this.data.emailId=='' || this.data.dateOfBirth=='' || this.data.aadhaarNo=='' || this.data.birthCertificate=='' || this.data.salarySlips=='' || this.data.gstrFiling==''){
//      this.snak.open("Fields cannot be empty","ok")         //here snak is the object of MatSnackBar
      alert("Fields cannot be empty")
      return;
    }

    this.regService.submitRegistration(this.data).subscribe(
      (response: any) => {
        console.log("Success!", response)
        alert(response.message)
      },
      error => {
        console.error("Error!", error)
        alert(error.message)
      }
    ) 
  }


}
