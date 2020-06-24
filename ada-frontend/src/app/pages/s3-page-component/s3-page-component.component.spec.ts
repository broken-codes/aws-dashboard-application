import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { S3PageComponentComponent } from './s3-page-component.component';

describe('S3PageComponentComponent', () => {
  let component: S3PageComponentComponent;
  let fixture: ComponentFixture<S3PageComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ S3PageComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(S3PageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
