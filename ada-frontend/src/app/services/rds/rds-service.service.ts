import { Injectable } from '@angular/core';
import { BaseConfigurations } from 'src/app/data/base-configurations';
import { Observable } from 'rxjs';
import { ArnRolesService } from '../arn-roles.service';

@Injectable({
  providedIn: 'root'
})
export class RdsServiceService {

  private baseUrl = `${BaseConfigurations.baseUrl}/api/rds`

  constructor(private arnRoleService: ArnRolesService) { }

  getBasicRdsInfo(): Observable<any> {
    return Observable.create((observer) => {
      const rdsBasicInformationProvidingEventSource = new EventSource(this.generateUrl('/information'));
      rdsBasicInformationProvidingEventSource.onmessage = (event) => {
        observer.next(event.data);
      };
      rdsBasicInformationProvidingEventSource.onerror = (error) => observer.complete();
      return () => rdsBasicInformationProvidingEventSource.close();
    });
  }

  generateUrl = (url: string) => `${this.baseUrl}${url}/?arn=${this.arnRoleService.getRole()}`;
}
