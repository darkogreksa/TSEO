import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UplateStudentuComponent } from './uplate-studentu.component';

describe('UplateStudentuComponent', () => {
  let component: UplateStudentuComponent;
  let fixture: ComponentFixture<UplateStudentuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UplateStudentuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UplateStudentuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
