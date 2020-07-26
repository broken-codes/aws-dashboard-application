import { Component, OnInit } from '@angular/core';
import { Ec2Service } from 'src/app/services/compute/ec2/ec2.service';

@Component({
  selector: 'app-c-transit-gateways',
  templateUrl: './c-transit-gateways.component.html',
  styleUrls: ['./c-transit-gateways.component.css']
})
export class CTransitGatewaysComponent implements OnInit {

  listOfTransitGatewayInformation = [];

  constructor(private service: Ec2Service) { }

  ngOnInit(): void {
    this.service.getTransitGateway()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfTransitGatewayInformation.push(
            new TransitGateway(this.listOfTransitGatewayInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class TransitGateway {

  key = 0;
  id = "";
  ownerId = "";
  state = "";
  tags = "";
  arn = "";
  createdOn = "";
  amazonSideAsn = 0;
  defaultRouteTableAssociation = "";
  dsnSupport = "";
  multicastSupport = "";
  propagationDefaultRouteTableId = "";
  vpnEcmpSupport = "";
  autoAcceptSharedAttachments = "";

  constructor(key: number, data: any) {
    this.key = data.key;
    this.id = data.id
    this.ownerId = data.ownerId
    this.state = data.state
    this.tags = data.tags
    this.arn = data.arn
    this.createdOn = data.createdOn
    this.amazonSideAsn = data.amazonSideAsn
    this.defaultRouteTableAssociation = data.defaultRouteTableAssociation
    this.dsnSupport = data.dsnSupport
    this.multicastSupport = data.multicastSupport
    this.propagationDefaultRouteTableId = data.propagationDefaultRouteTableId
    this.vpnEcmpSupport = data.vpnEcmpSupport
    this.autoAcceptSharedAttachments = data.autoAcceptSharedAttachments
  }

}