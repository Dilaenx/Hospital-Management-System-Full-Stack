import { Component } from '@angular/core';
import { NavComponent } from "../../common/nav/nav.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-dashbord',
  standalone: true,
  imports: [NavComponent,RouterOutlet],
  templateUrl: './dashbord.component.html',
  styleUrl: './dashbord.component.css'
})
export class DashbordComponent {

}
