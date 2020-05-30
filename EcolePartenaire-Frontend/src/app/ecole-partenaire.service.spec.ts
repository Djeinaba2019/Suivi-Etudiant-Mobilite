import { TestBed } from '@angular/core/testing';

import { EcolePartenaireService } from './ecole-partenaire.service';

describe('EcolePartenaireService', () => {
  let service: EcolePartenaireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EcolePartenaireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
