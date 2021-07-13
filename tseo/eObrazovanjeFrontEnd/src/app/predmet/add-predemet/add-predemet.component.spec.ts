import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPredemetComponent } from './add-predemet.component';

describe('AddPredemetComponent', () => {
  let component: AddPredemetComponent;
  let fixture: ComponentFixture<AddPredemetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPredemetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPredemetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
