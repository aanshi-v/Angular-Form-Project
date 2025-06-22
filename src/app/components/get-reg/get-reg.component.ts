import { Component, OnInit } from '@angular/core';
import { RegistrationService } from 'src/app/service/registration.service';

@Component({
  selector: 'app-get-reg',
  templateUrl: './get-reg.component.html',
  styleUrls: ['./get-reg.component.css']
})
export class GetRegComponent implements OnInit {

  data = {
    customerId : "",
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

  
  data2 = null;

  constructor(private regService: RegistrationService) {
    this.getRegDetails();
   }

  ngOnInit(): void {
  }


  getRegDetails(){                                             
    console.log("Try to get Details...")
    console.log(this.data2)

  this.regService.getRegData().subscribe(
    (response: any) => {
      console.log("Success!", response)
      this.data2 = response;
    },
    (error: any) => {
      console.log("Error!", error)
    }
  )
  }


  deleteRegisDataById(reg:any){
    console.log("Try to delete Details...")

    this.regService.deleteRegisDataById(reg.customerId).subscribe(
      (response: any) => {
        console.log("Success!", response)
        this.getRegDetails();
      },
      (error: any) => {
        console.log("Error!", error)
      }
    )
  }


  edit(reg:any){
    console.log("Try to edit Details...")
    this.data = reg;
  }

    updateRegsData(){
    console.log("Try to update Details...")
    this.regService.updateRegsData(this.data).subscribe(
      (response: any) => {
        console.log("Success!", response)
      },
      (error: any) => {
        console.log("Error!", error)
      }
    )
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





}
