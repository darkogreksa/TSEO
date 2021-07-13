import { TestBed } from '@angular/core/testing';

import { IspitniRokService } from './ispitni-rok.service';

describe('IspitniRokService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IspitniRokService = TestBed.get(IspitniRokService);
    expect(service).toBeTruthy();
  });
});
