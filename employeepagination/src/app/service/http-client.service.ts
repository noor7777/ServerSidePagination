import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

export class Emp{
  constructor(
  public id:number,
  public name:string,){}

}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
 

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     
     getEmp(page: number, size:number)
  {
    console.log("test call");
    return this.httpClient.get<Emp[]>('http://localhost:8080/employee' + '/' + page + '/' + size);
  }
  
    
  getEmpCount( )
  {
    console.log("test call");
    return this.httpClient.get('http://localhost:8080/employee');
  }


  /**
   * Spring boot
   * repo add method return type
   * 
   * 
   */
  

  
}
