import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CRouteTablesComponent } from './c-route-tables.component';

describe('CRouteTablesComponent', () => {
  let component: CRouteTablesComponent;
  let fixture: ComponentFixture<CRouteTablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CRouteTablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CRouteTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
