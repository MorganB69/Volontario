import { TestBed } from '@angular/core/testing';

import { SiretService } from './siret.service';

describe('SiretService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SiretService = TestBed.get(SiretService);
    expect(service).toBeTruthy();
  });
});
