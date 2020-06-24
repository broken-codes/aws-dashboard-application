import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CS3BasicInformationComponent } from './c-s3-basic-information.component';

describe('CS3BasicInformationComponent', () => {
  let component: CS3BasicInformationComponent;
  let fixture: ComponentFixture<CS3BasicInformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CS3BasicInformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CS3BasicInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
