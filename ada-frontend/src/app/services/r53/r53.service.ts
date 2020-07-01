import { Injectable } from '@angular/core';
import { BaseConfigurations } from 'src/app/data/base-configurations';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class R53Service {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/r53`

  constructor() { }

  getHostedZoneBasicInformation(): Observable<any> {
    return Observable.create((observer) => {
      const hostedZonesBasicInformationProvidingEventSource = new EventSource(this.generateUrl('/hosted-zones'));
      hostedZonesBasicInformationProvidingEventSource.onmessage = (event) => {
        observer.next(event.data);
      };
      hostedZonesBasicInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => hostedZonesBasicInformationProvidingEventSource.close();
    });
  }

  generateUrl = (url: string) => `${this.baseUrl}${url}`;
}
