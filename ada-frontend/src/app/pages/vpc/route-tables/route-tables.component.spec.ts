import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RouteTablesComponent } from './route-tables.component';

describe('RouteTablesComponent', () => {
  let component: RouteTablesComponent;
  let fixture: ComponentFixture<RouteTablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RouteTablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RouteTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
