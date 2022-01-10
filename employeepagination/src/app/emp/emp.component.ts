import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { concat } from 'rxjs';
import { Emp, HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {
  noOfRecordsToFetchPerDbCall= 100;
  currentPage: number =0;
  totalRecords: number = 0;

  
  emps:any;
  ELEMENT_DATA: Emp[] = [];
  displayedColumns: string[] = ['id', 'name'];
  dataSource = new MatTableDataSource<Emp>(this.ELEMENT_DATA);
  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;
   pageFrom: number = 0;
  pageBlockFetched : number = 100;
  cummulativedataSource: any;
  dataFetched: boolean = false;
  public getPaginatorData(event: PageEvent) : PageEvent{
  
    this.currentPage = event.pageIndex;
    this.currentPage += 1;
    let recordsRequested = this.currentPage*event.pageSize; 
    let currentBlockLimit = this.round(recordsRequested);
    console.log('Cieling-' +  currentBlockLimit);
     if( (recordsRequested > currentBlockLimit - 100 && recordsRequested < currentBlockLimit) && this.dataFetched == false ){
       console.log('Getting data from DB-');
       this.getEmpnew(++this.pageFrom);
       this.dataFetched = true;
    } 
    else{
      this.dataFetched = false;
    }
   
    return event;
   
  }
  
constructor(
    private httpClientService:HttpClientService
  ) { }

  ngOnInit(){
    
    this.getEmpnew(this.pageFrom);
    this.dataSource.paginator = this.paginator;
    
  }
 public getEmpnew(pageFrom : number){
  
   this.httpClientService.getEmp(pageFrom,this.noOfRecordsToFetchPerDbCall).subscribe(data => {
   this.dataSource.data= [...this.dataSource.data,...data] ;
     this.getNewcount();
   })
   
      
 }
 public  getNewcount(){
  
   this.httpClientService.getEmpCount().subscribe(val => {
    console.log('totalRecords-' + val) ;
    this.totalRecords=val as number; 
    
   } );
   
  
   }

   round( input: number) {
    return Math.ceil(input/100)*100;
}
/** 
 * 
 * offset : 0;
 * limit :[5,10,20]
 * api = baseaddress?{offset}?{limit}
 * springboot api 
 */
}