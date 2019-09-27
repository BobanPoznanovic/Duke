import { TestBed } from '@angular/core/testing';

import { DukeRestService } from './duke-rest.service';

describe('DukeRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DukeRestService = TestBed.get(DukeRestService);
    expect(service).toBeTruthy();
  });
});
