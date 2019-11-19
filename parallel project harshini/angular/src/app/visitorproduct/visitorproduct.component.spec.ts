import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitorproductComponent } from './visitorproduct.component';

describe('VisitorproductComponent', () => {
  let component: VisitorproductComponent;
  let fixture: ComponentFixture<VisitorproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitorproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitorproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
