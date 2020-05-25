import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DVpcInfoComponent } from './d-vpc-info.component';

describe('DVpcInfoComponent', () => {
  let component: DVpcInfoComponent;
  let fixture: ComponentFixture<DVpcInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DVpcInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DVpcInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
