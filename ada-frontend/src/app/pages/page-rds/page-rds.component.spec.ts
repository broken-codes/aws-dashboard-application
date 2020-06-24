import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageRdsComponent } from './page-rds.component';

describe('PageRdsComponent', () => {
  let component: PageRdsComponent;
  let fixture: ComponentFixture<PageRdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageRdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageRdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
