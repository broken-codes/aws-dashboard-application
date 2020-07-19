import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { ArnRolesService } from './services/arn-roles.service';
import { map } from "rxjs/operators";

@Injectable()
export class RoleAdderInterceptor implements HttpInterceptor {

  constructor(private arnRoleService: ArnRolesService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // console.log(this.arnRoleService.getRole());
    return next.handle(request)
      .pipe(
        map((event: HttpEvent<any>) => {
          // if (event instanceof HttpResponse) {
            console.log('event ' + event);
            return event;
          // }
        })
      )
  }
}
