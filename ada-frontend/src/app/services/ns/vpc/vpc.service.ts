import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BaseConfigurations } from 'src/app/data/base-configurations';

@Injectable({
  providedIn: 'root'
})
export class VpcService {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/ns/vpc`

  constructor() { }

  getVpcBasicInformation(): Observable<any> {
    return Observable.create((observer) => {
      const vpcBasicInformationProvidingEventSource = new EventSource(this.generateUrl('/info'));
      vpcBasicInformationProvidingEventSource.onmessage = (event) => {
        observer.next(event.data);
      };
      vpcBasicInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => vpcBasicInformationProvidingEventSource.close();
    });
  }

  getSubnetsInformation(): Observable<any> {
    return Observable.create((observer) => {
      const subnetsInformationProvidingEventSource = new EventSource(this.generateUrl('/subnets'));
      subnetsInformationProvidingEventSource.onmessage = (event) => observer.next(event.data);
      subnetsInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => subnetsInformationProvidingEventSource.close();
    });
  }

  getRouteTablesInformation(): Observable<any> {
    return Observable.create((observer) => {
      const routeTableInformationProvidingEventSource = new EventSource(this.generateUrl('/route-tables'));
      routeTableInformationProvidingEventSource.onmessage = (event) => observer.next(event.data);
      routeTableInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => routeTableInformationProvidingEventSource.close();
    });
  }

  getVpcPeeringInformation(): Observable<any> {
    return Observable.create((observer) => {
      const vpcPeeringInformationProvidingEventSource = new EventSource(this.generateUrl('/vpc-peering'));
      vpcPeeringInformationProvidingEventSource.onmessage = (event) => observer.next(event.data);
      vpcPeeringInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => vpcPeeringInformationProvidingEventSource.close();
    });
  }

  generateUrl = (url: string) => `${this.baseUrl}${url}`;
}
