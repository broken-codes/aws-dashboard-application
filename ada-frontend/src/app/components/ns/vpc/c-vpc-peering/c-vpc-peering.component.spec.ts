import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CVpcPeeringComponent } from './c-vpc-peering.component';

describe('CVpcPeeringComponent', () => {
  let component: CVpcPeeringComponent;
  let fixture: ComponentFixture<CVpcPeeringComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CVpcPeeringComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CVpcPeeringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
