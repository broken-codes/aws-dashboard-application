import { Component, OnInit } from '@angular/core';
import { ArnRolesService } from 'src/app/services/arn-roles.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  isCollapsed = false;
  selectedRole = 'arn:aws:iam::517949891193:role/CA-ROL-APID';

  constructor(private arnRoleService: ArnRolesService) { }

  ngOnInit(): void {
  }

  onRoleChange(event: Event) {
    console.log(this.selectedRole)
    this.arnRoleService.setRole(this.selectedRole);
  }
}
