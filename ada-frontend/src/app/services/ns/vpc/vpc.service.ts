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

  generateUrl = (url: string) => `${this.baseUrl}${url}`;
}
