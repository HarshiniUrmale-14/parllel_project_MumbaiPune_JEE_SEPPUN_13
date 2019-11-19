import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeerequestComponent } from './seerequest.component';

describe('SeerequestComponent', () => {
  let component: SeerequestComponent;
  let fixture: ComponentFixture<SeerequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeerequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeerequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
