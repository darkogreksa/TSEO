import { TestBed } from '@angular/core/testing';

import { DokumentiService } from './dokumenti.service';

describe('DokumentiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DokumentiService = TestBed.get(DokumentiService);
    expect(service).toBeTruthy();
  });
});
