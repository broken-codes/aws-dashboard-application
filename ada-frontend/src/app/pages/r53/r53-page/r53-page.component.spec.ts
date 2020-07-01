import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { R53PageComponent } from './r53-page.component';

describe('R53PageComponent', () => {
  let component: R53PageComponent;
  let fixture: ComponentFixture<R53PageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ R53PageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(R53PageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
