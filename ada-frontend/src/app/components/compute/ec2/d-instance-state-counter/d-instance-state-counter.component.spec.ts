import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DInstanceStateCounterComponent } from './d-instance-state-counter.component';

describe('DInstanceStateCounterComponent', () => {
  let component: DInstanceStateCounterComponent;
  let fixture: ComponentFixture<DInstanceStateCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DInstanceStateCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DInstanceStateCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
