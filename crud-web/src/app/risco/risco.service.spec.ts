import { TestBed, inject } from '@angular/core/testing';

import { RiscoService } from './risco.service';

describe('RiscoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RiscoService]
    });
  });

  it('should be created', inject([RiscoService], (service: RiscoService) => {
    expect(service).toBeTruthy();
  }));
});
