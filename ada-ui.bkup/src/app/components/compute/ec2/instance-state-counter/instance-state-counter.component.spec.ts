import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstanceStateCounterComponent } from './instance-state-counter.component';

describe('InstanceStateCounterComponent', () => {
  let component: InstanceStateCounterComponent;
  let fixture: ComponentFixture<InstanceStateCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstanceStateCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstanceStateCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
