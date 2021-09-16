import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteQuizzesComponent } from './delete-quizzes.component';

describe('DeleteQuizzesComponent', () => {
  let component: DeleteQuizzesComponent;
  let fixture: ComponentFixture<DeleteQuizzesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteQuizzesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
