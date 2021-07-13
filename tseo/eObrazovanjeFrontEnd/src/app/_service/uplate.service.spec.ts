import { TestBed } from '@angular/core/testing';

import { UplateService } from './uplate.service';

describe('UplateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UplateService = TestBed.get(UplateService);
    expect(service).toBeTruthy();
  });
});
