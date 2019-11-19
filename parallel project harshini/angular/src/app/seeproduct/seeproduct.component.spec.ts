import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeproductComponent } from './seeproduct.component';

describe('SeeproductComponent', () => {
  let component: SeeproductComponent;
  let fixture: ComponentFixture<SeeproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
