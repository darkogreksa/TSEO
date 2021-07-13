import { TestBed } from '@angular/core/testing';

import { IspitService } from './ispit.service';

describe('IspitService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IspitService = TestBed.get(IspitService);
    expect(service).toBeTruthy();
  });
});
