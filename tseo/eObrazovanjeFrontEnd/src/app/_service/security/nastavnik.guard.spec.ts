import { TestBed, async, inject } from '@angular/core/testing';

import { NastavnikGuard } from './nastavnik.guard';

describe('NastavnikGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NastavnikGuard]
    });
  });

  it('should ...', inject([NastavnikGuard], (guard: NastavnikGuard) => {
    expect(guard).toBeTruthy();
  }));
});
