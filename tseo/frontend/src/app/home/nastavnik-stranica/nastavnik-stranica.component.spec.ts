import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavnikStranicaComponent } from './nastavnik-stranica.component';

describe('NastavnikStranicaComponent', () => {
  let component: NastavnikStranicaComponent;
  let fixture: ComponentFixture<NastavnikStranicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NastavnikStranicaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NastavnikStranicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
