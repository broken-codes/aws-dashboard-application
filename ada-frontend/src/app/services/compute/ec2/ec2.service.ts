import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { BaseConfigurations } from 'src/app/data/base-configurations';

@Injectable({
  providedIn: 'root'
})
export class Ec2Service {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/compute/ec2`

  constructor() { }

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

  generateUrl = (url: string) => `${this.baseUrl}${url}`;
}
