import { TestBed } from '@angular/core/testing';

import { RoleAdderInterceptor } from './role-adder.interceptor';

describe('RoleAdderInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      RoleAdderInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: RoleAdderInterceptor = TestBed.inject(RoleAdderInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
