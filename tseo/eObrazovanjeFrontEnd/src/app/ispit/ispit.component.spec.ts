import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IspitComponent } from './ispit.component';

describe('IspitComponent', () => {
  let component: IspitComponent;
  let fixture: ComponentFixture<IspitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IspitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IspitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
