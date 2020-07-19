import { TestBed } from '@angular/core/testing';

import { ArnRolesService } from './arn-roles.service';

describe('ArnRolesService', () => {
  let service: ArnRolesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArnRolesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
