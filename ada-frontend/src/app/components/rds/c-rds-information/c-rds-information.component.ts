import { Component, OnInit } from '@angular/core';
import { RdsServiceService } from 'src/app/services/rds/rds-service.service';

@Component({
  selector: 'app-c-rds-information',
  templateUrl: './c-rds-information.component.html',
  styleUrls: ['./c-rds-information.component.css']
})
export class CRdsInformationComponent implements OnInit {

  listOfRdsBasicInformation = [];

  constructor(private rdsService: RdsServiceService) { }

  ngOnInit(): void {
    this.rdsService.getBasicRdsInfo()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfRdsBasicInformation.push(
            new RdsBasicInformation(this.listOfRdsBasicInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class RdsBasicInformation {

  key = 0;
  dbId = "";
  engine = "";
  engineVersion = "";
  dbStatus = "";
  endpoint = "";
  availabilityZone = "";
  dbInstanceArn = "";
  instanceCreationTime = "";
  associatedVpcId = "";
  dbSubnetGroupName = "";

  constructor(key: number, data: any) {
    this.key = data.key;
    this.dbId = data.dbId;
    this.engine = data.engine;
    this.engineVersion = data.engineVersion;
    this.dbStatus = data.dbStatus;
    this.endpoint = data.endpoint;
    this.availabilityZone = data.availabilityZone;
    this.dbInstanceArn = data.dbInstanceArn;
    this.instanceCreationTime = data.instanceCreationTime;
    this.associatedVpcId = data.associatedVpcId;
    this.dbSubnetGroupName = data.dbSubnetGroupName;
  }

}