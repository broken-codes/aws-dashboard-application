import { TestBed } from '@angular/core/testing';

import { R53Service } from './r53.service';

describe('R53Service', () => {
  let service: R53Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(R53Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
