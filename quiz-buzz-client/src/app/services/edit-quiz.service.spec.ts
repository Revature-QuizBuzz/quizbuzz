import { TestBed } from '@angular/core/testing';

import { EditQuizService } from './edit-quiz.service';

describe('EditQuizServiceService', () => {
  let service: EditQuizService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EditQuizService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
