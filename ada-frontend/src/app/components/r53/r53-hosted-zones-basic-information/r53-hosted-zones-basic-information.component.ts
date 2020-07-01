import { Component, OnInit } from '@angular/core';
import { R53Service } from 'src/app/services/r53/r53.service';

@Component({
  selector: 'app-r53-hosted-zones-basic-information',
  templateUrl: './r53-hosted-zones-basic-information.component.html',
  styleUrls: ['./r53-hosted-zones-basic-information.component.css']
})
export class R53HostedZonesBasicInformationComponent implements OnInit {

  listOfHostedZonesBasicInformation = [];

  constructor(private r53Service: R53Service) { }

  ngOnInit(): void {
    this.r53Service.getHostedZoneBasicInformation()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfHostedZonesBasicInformation.push(
            new HostedZoneBasicInformation(this.listOfHostedZonesBasicInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class HostedZoneBasicInformation {

  key = 0;
  id = "";
  name = "";
  callerReference = "";
  resourceRecordSetCount = "";
  isPrivateZone = "";
  servicePrincipal = "";

  constructor(key: number, data: any) {
    this.key = data.key;
    this.id = data.id;
    this.name = data.name;
    this.callerReference = data.callerReference;
    this.resourceRecordSetCount = data.resourceRecordSetCount;
    this.isPrivateZone = data.isPrivateZone;
    this.servicePrincipal = data.servicePrincipal;
  }
}
