/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { UpisOcenaComponent } from './upis-ocena.component';

describe('UpisOcenaComponent', () => {
  let component: UpisOcenaComponent;
  let fixture: ComponentFixture<UpisOcenaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpisOcenaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpisOcenaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
