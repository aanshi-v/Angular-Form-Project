import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  //private baseUrl = "http://localhost:8080"
  private baseUrl = "http://localhost:9191"


  constructor(private http: HttpClient) { }

  submitRegistration(data:any){                                             //creted a method to submit the data
    return this.http.post(`${this.baseUrl}/bank/bankController/addCustomerRegistration`,data)
  }

  getRegData(){
    return this.http.get(this.baseUrl + '/bank/bankController/getRegDetails') 
  }

  public deleteRegisDataById(customerId: any){
    return this.http.delete(this.baseUrl + '/bank/bankController/deleteRegisDataById?customerId=' + customerId);
  }


  public updateRegsData(data:any){
    return this.http.put(this.baseUrl + '/bank/bankController/updateRegsData',data);
  }






}
