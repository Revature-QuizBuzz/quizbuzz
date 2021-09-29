import { TestBed } from '@angular/core/testing';

import { CreateQuizService } from './create-quiz.service';

describe('CreateQuizService', () => {
  let service: CreateQuizService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateQuizService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
