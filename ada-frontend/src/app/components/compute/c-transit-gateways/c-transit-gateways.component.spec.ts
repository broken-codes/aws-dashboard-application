import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CTransitGatewaysComponent } from './c-transit-gateways.component';

describe('CTransitGatewaysComponent', () => {
  let component: CTransitGatewaysComponent;
  let fixture: ComponentFixture<CTransitGatewaysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CTransitGatewaysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CTransitGatewaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
