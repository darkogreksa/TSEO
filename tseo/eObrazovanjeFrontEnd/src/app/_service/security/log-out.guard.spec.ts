import { TestBed, async, inject } from '@angular/core/testing';

import { LogOutGuard } from './log-out.guard';

describe('LogOutGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LogOutGuard]
    });
  });

  it('should ...', inject([LogOutGuard], (guard: LogOutGuard) => {
    expect(guard).toBeTruthy();
  }));
});
