import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizSelectionComponent } from './quiz-selection.component';

describe('QuizSelectionComponent', () => {
  let component: QuizSelectionComponent;
  let fixture: ComponentFixture<QuizSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizSelectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
