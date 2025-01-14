import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-patient-manage',
  standalone: true,
  imports: [CommonModule,FormsModule],
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
  deletePatient(id:any){

    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.http.delete(`http://localhost:8080/delete-by-id/${id}`).subscribe(data=>{
          this.loadpatient();
          
        })
        
        Swal.fire({
          title: "Deleted!",
          text: "Your file has been deleted.",
          icon: "success"
        });
      }
    }); 
  }
  
  public selectPatientDetails:any={};
  selectaPatient(patient:any){
    console.log(patient);
    this.selectPatientDetails=patient;
  }

  updateSelectedPatient(){
    

    Swal.fire({
      title: "Do you want to save the changes?",
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: "Save",
      denyButtonText: `Don't save`
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.http.put("http://localhost:8080/update",this.selectPatientDetails).subscribe(res=>{})
        Swal.fire("Saved!", "", "success");
      } else if (result.isDenied) {
        Swal.fire("Changes are not saved", "", "info");
      }
    });
  }
}
