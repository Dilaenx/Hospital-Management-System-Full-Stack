import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-patient-manage',
  standalone: true,
  imports: [HttpClientModule,CommonModule,FormsModule],
  templateUrl: './patient-manage.component.html',
  styleUrl: './patient-manage.component.css'
})
export class PatientManageComponent {

  public patientList:any=[];
  constructor(private http:HttpClient){
    console.log("hello");
    this.loadpatient();
  
  }
  loadpatient(){
    this.http.get("http://localhost:8080/get-all").subscribe(data=>{
      console.log(data);
      this.patientList=data; 
    })
  }
}
