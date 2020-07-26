import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransitGatewaysComponent } from './transit-gateways.component';

describe('TransitGatewaysComponent', () => {
  let component: TransitGatewaysComponent;
  let fixture: ComponentFixture<TransitGatewaysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransitGatewaysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransitGatewaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
