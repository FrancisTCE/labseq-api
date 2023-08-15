import { TestBed } from '@angular/core/testing';

import { ApiLabseqService } from './api-labseq.service';

describe('ApiLabseqService', () => {
  let service: ApiLabseqService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiLabseqService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
