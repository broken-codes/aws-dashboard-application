import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Ec2Service {

  constructor(private httpClient: HttpClient) { }

  getEc2InstanceStateCount(): Observable<any> {
    return Observable.create((observer) => {
      const ec2InstanceStateCounterProvidingEventSource = new EventSource('http://localhost:8080/api/compute/ec2/instances/counter');
      ec2InstanceStateCounterProvidingEventSource.onmessage = (event) => {
        console.log("Event" + event);
        observer.next(event.data);
      };
      ec2InstanceStateCounterProvidingEventSource.onerror = (error) => observer.complete();
      return () => ec2InstanceStateCounterProvidingEventSource.close();
    });
  }
}
