import { Component, OnInit } from '@angular/core';
import { VpcService } from 'src/app/services/ns/vpc/vpc.service';

@Component({
  selector: 'app-c-route-tables',
  templateUrl: './c-route-tables.component.html',
  styleUrls: ['./c-route-tables.component.css']
})
export class CRouteTablesComponent implements OnInit {

  listOfRouteTableInformation = [];

  constructor(private vpcService: VpcService) { }

  ngOnInit(): void {
    this.vpcService.getRouteTablesInformation()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfRouteTableInformation.push(
            new RouteTableInformationTableRow(this.listOfRouteTableInformation.length + 1, obtainedData)
          )
          console.log(this.listOfRouteTableInformation)
        },
        error => {
          console.log("Error processing")
        }
      );
  }
  
}
export class RouteTableInformationTableRow {

  key = 0;
  routeTableId = "";
  vpcId = "";
  ownerId = "";

  constructor(key: number, data: any) {
    this.key = key;
    this.routeTableId = data.routeTableId;
    this.vpcId = data.vpcId;
    this.ownerId = data.owner;
  }
}