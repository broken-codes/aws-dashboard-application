import { Component, OnInit } from '@angular/core';
import { VpcService } from 'src/app/services/ns/vpc/vpc.service';

@Component({
  selector: 'app-d-vpc-info',
  templateUrl: './d-vpc-info.component.html',
  styleUrls: ['./d-vpc-info.component.css']
})
export class DVpcInfoComponent implements OnInit {

  listOfVpcBasicInformation = [];

  constructor(private vpcService: VpcService) { }

  ngOnInit(): void {
    this.vpcService.getVpcBasicInformation()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfVpcBasicInformation.push(
            new VpcBasicInformationTableRow(this.listOfVpcBasicInformation.length + 1, obtainedData)
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
  name = "";
  vpcId = "";
  ipv4CIDR = "";
  isDefaultVPC = false;
  state = "";

  constructor(key: number, data: any) {
    this.key = key;
    this.name = data.name;
    this.vpcId = data.vpcId;
    this.ipv4CIDR = data.ipv4CIDR;
    this.isDefaultVPC = data.defaultVPC;
    this.state = data.state;
  }

}