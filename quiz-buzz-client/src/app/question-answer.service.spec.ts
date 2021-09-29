import { TestBed } from '@angular/core/testing';

import { QuestionAnswerService } from './question-answer.service';

describe('QuestionAnswerService', () => {
  let service: QuestionAnswerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuestionAnswerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
