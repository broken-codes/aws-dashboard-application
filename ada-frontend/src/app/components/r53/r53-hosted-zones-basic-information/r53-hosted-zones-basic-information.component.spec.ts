import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { R53HostedZonesBasicInformationComponent } from './r53-hosted-zones-basic-information.component';

describe('R53HostedZonesBasicInformationComponent', () => {
  let component: R53HostedZonesBasicInformationComponent;
  let fixture: ComponentFixture<R53HostedZonesBasicInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ R53HostedZonesBasicInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(R53HostedZonesBasicInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
