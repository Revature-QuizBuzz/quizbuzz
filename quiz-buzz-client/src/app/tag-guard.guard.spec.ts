import { TestBed } from '@angular/core/testing';

import { TagGuardGuard } from './tag-guard.guard';

describe('TagGuardGuard', () => {
  let guard: TagGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TagGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
