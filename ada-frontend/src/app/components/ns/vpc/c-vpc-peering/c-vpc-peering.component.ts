import { Component, OnInit } from '@angular/core';
import { VpcService } from 'src/app/services/ns/vpc/vpc.service';

@Component({
  selector: 'app-c-vpc-peering',
  templateUrl: './c-vpc-peering.component.html',
  styleUrls: ['./c-vpc-peering.component.css']
})
export class CVpcPeeringComponent implements OnInit {

  listOfVpcPeeringInformation = [];

  constructor(private vpcService: VpcService) { }

  ngOnInit(): void {
    this.vpcService.getVpcPeeringInformation()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfVpcPeeringInformation.push(
            new VpcPeeringConnectionTableRow(this.listOfVpcPeeringInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class VpcPeeringConnectionTableRow {

  key = 0;
  id = "";
  validity = "";
  status = "";
  acceptingVpcId = "";
  acceptingConnectionOwner = "";
  acceptingConnectionCidr = "";
  acceptingRegion = "";
  acceptingAllowsDnsResolutionFromRemote = "";
  acceptingAllowEgressFromLocalClassicLinkToRemoteVpc = "";
  acceptingAllowEgressFromLocalVpcToRemoteClassicLink = "";
  requesterAllowsDnsResolutionFromRemote = "";
  requesterAllowEgressFromLocalClassicLinkToRemoteVpc = "";
  requesterAllowEgressFromLocalVpcToRemoteClassicLink = "";
  requesterVpcId = "";
  requesterConnectionOwner = "";
  requesterConnectionCidr = "";
  requesterRegion = "";

  constructor(key: number, data: any) {
    this.key = key;
    this.id = data.id;
    this.validity = data.validity;
    this.status = data.status;
    this.acceptingVpcId = data.acceptingVpcId;
    this.acceptingConnectionOwner = data.acceptingConnectionOwner;
    this.acceptingConnectionCidr = data.acceptingConnectionCidr;
    this.acceptingRegion = data.acceptingRegion;
    this.acceptingAllowsDnsResolutionFromRemote = data.acceptingAllowsDnsResolutionFromRemote;
    this.acceptingAllowEgressFromLocalClassicLinkToRemoteVpc = data.acceptingAllowEgressFromLocalClassicLinkToRemoteVpc;
    this.acceptingAllowEgressFromLocalVpcToRemoteClassicLink = data.acceptingAllowEgressFromLocalVpcToRemoteClassicLink;
    this.requesterAllowsDnsResolutionFromRemote = data.requesterAllowsDnsResolutionFromRemote;
    this.requesterAllowEgressFromLocalClassicLinkToRemoteVpc = data.requesterAllowEgressFromLocalClassicLinkToRemoteVpc;
    this.requesterAllowEgressFromLocalVpcToRemoteClassicLink = data.requesterAllowEgressFromLocalVpcToRemoteClassicLink;
    this.requesterVpcId = data.requesterVpcId;
    this.requesterConnectionOwner = data.requesterConnectionOwner;
    this.requesterConnectionCidr = data.requesterConnectionCidr;
    this.requesterRegion = data.requesterRegion;
  }

}