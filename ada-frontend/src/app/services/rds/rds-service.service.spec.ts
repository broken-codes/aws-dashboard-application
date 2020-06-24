import { TestBed } from '@angular/core/testing';

import { RdsServiceService } from './rds-service.service';

describe('RdsServiceService', () => {
  let service: RdsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RdsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
