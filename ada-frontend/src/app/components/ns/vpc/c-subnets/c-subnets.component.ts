import { Component, OnInit } from '@angular/core';
import { VpcService } from 'src/app/services/ns/vpc/vpc.service';

@Component({
  selector: 'app-c-subnets',
  templateUrl: './c-subnets.component.html',
  styleUrls: ['./c-subnets.component.css']
})
export class CSubnetsComponent implements OnInit {

  listOfSubnetsInformation = [];

  constructor(private vpcService: VpcService) { }

  ngOnInit(): void {
    this.vpcService.getSubnetsInformation()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfSubnetsInformation.push(
            new VpcBasicInformationTableRow(this.listOfSubnetsInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class VpcBasicInformationTableRow {

  key = 0;
  availabilityZone = "";
  ipv4Cidr = "";
  availableIpv4AddressCount = "";
  isDefaultForAz = false;
  state = "";
  vpcId = "";
  ownerId = "";
  subnetArn = "";

  constructor(key: number, data: any) {
    this.key = key;
    this.availabilityZone = data.availabilityZone;
    this.ipv4Cidr = data.ipv4Cidr;
    this.availableIpv4AddressCount = data.availableIpv4AddressCount;
    this.isDefaultForAz = data.isDefaultForAz;
    this.state = data.state;
    this.vpcId = data.vpcId;
    this.ownerId = data.ownerId;
    this.subnetArn = data.subnetArn;
  }

}
