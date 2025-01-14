import { Routes } from '@angular/router';
import { AppoinmentManageComponent } from './page/appoinment-manage/appoinment-manage.component';
import { PatientManageComponent } from './page/patient-manage/patient-manage.component';
import { LoginComponent } from './page/login/login.component';
import { DashbordComponent } from './page/dashbord/dashbord.component';

export const routes: Routes = [
    {
        path:"",
        component:LoginComponent
    },
    {
        path:"appointment",
        component:AppoinmentManageComponent
    },
    {
        path:"patient",
        component:PatientManageComponent
    },
    {
        path:"dash",
        component:DashbordComponent,
        children:[
            {
                path:"appointment",
                component:AppoinmentManageComponent
            },
            {
                path:"patient",
                component:PatientManageComponent
            }
        ]
    },
    
];
