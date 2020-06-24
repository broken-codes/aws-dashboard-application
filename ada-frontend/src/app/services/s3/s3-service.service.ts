import { Injectable } from '@angular/core';
import { BaseConfigurations } from 'src/app/data/base-configurations';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class S3ServiceService {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/s3`

  constructor() { }

  getBasicS3Information(): Observable<any> {
    return Observable.create((observer) => {
      const s3BasicInformationProvidingEventSource = new EventSource(this.generateUrl('/information'));
      s3BasicInformationProvidingEventSource.onmessage = (event) => {
        observer.next(event.data);
      };
      s3BasicInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => s3BasicInformationProvidingEventSource.close();
    });
  }

  generateUrl = (url: string) => `${this.baseUrl}${url}`;
}
