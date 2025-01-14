import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-appoinment-manage',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './appoinment-manage.component.html',
  styleUrl: './appoinment-manage.component.css'
})
export class AppoinmentManageComponent {

      public appoinmentList:any=[];
      public selectedAppoinmentDetails:any={};

      constructor(private http:HttpClient){
        this.loadTable();
      }

      loadTable(){
        this.http.get("http://localhost:8080/Appoinment/view-all-appoinment").subscribe(res=>{
          console.log(res);
          this.appoinmentList=res;
          
        })
      }
      selectaAppoinment(appoinmentDetails:any){
        this.selectedAppoinmentDetails=appoinmentDetails;
      }
      deleteAppoinment(id:any){

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
            this.http.delete(`http://localhost:8080/Appoinment/delete-appoinment/${id}`).subscribe(res=>{})
            Swal.fire({
              title: "Deleted!",
              text: "Your file has been deleted.",
              icon: "success"
            });
          }
        });
      }
      updateAppoinment(){
       
         this.http.put("http://localhost:8080/Appoinment/update-appoinment",this.selectedAppoinmentDetails).subscribe(res=>{

         });
         
         
         Swal.fire({
          title: "UPDATE SUCCESSFULLY!",
          icon: "success",
          draggable: true
        });
        this.loadTable();
      }
    
}
