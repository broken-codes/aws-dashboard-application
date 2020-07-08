import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VpcPeeringComponent } from './vpc-peering.component';

describe('VpcPeeringComponent', () => {
  let component: VpcPeeringComponent;
  let fixture: ComponentFixture<VpcPeeringComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VpcPeeringComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VpcPeeringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
