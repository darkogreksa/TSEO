import { TestBed } from '@angular/core/testing';

import { UplateService } from './uplate.service';

describe('UplateService', () => {
  let service: UplateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UplateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
