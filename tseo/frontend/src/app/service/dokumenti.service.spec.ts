import { TestBed } from '@angular/core/testing';

import { DokumentiService } from './dokumenti.service';

describe('DokumentiService', () => {
  let service: DokumentiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DokumentiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
