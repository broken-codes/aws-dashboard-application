import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { BaseConfigurations } from 'src/app/data/base-configurations';
import { ArnRolesService } from '../../arn-roles.service';

@Injectable({
  providedIn: 'root'
})
export class Ec2Service {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/compute/ec2`

  constructor(private arnRoleService: ArnRolesService) { }

  getEc2InstanceStateCount(): Observable<any> {
    return Observable.create((observer) => {
      const ec2InstanceStateCounterProvidingEventSource = new EventSource(this.generateUrl('/instances/counter'));
      ec2InstanceStateCounterProvidingEventSource.onmessage = (event) => {
        console.log("Event" + event);
        observer.next(event.data);
      };
      ec2InstanceStateCounterProvidingEventSource.onerror = (error) => observer.complete();
      return () => ec2InstanceStateCounterProvidingEventSource.close();
    });
  }

  getTransitGateway(): Observable<any> {
    return Observable.create((observer) => {
      const transitGatewayProvidingEventSource = new EventSource(this.generateUrl('/gateways/transit'));
      transitGatewayProvidingEventSource.onmessage = (event) => {
        console.log("Event" + event);
        observer.next(event.data);
      };
      transitGatewayProvidingEventSource.onerror = (error) => observer.complete();
      return () => transitGatewayProvidingEventSource.close();
    });
  }

  generateUrl = (url: string) => `${this.baseUrl}${url}?arn=${this.arnRoleService.getRole()}`;
}
