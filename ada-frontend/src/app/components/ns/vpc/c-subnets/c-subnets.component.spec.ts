import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CSubnetsComponent } from './c-subnets.component';

describe('CSubnetsComponent', () => {
  let component: CSubnetsComponent;
  let fixture: ComponentFixture<CSubnetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CSubnetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CSubnetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
