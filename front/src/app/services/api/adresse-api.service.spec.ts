import { TestBed } from '@angular/core/testing';

import { AdresseApiService } from './adresse-api.service';

describe('AdresseApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdresseApiService = TestBed.get(AdresseApiService);
    expect(service).toBeTruthy();
  });
});
