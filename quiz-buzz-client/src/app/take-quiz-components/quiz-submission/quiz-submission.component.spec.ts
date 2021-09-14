import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizSubmissionComponent } from './quiz-submission.component';

describe('QuizSubmissionComponent', () => {
  let component: QuizSubmissionComponent;
  let fixture: ComponentFixture<QuizSubmissionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizSubmissionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizSubmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
