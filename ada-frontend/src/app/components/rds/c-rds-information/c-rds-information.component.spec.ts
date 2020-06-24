import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CRdsInformationComponent } from './c-rds-information.component';

describe('CRdsInformationComponent', () => {
  let component: CRdsInformationComponent;
  let fixture: ComponentFixture<CRdsInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CRdsInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CRdsInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
