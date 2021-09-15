import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCreatedQuizzesComponent } from './list-created-quizzes.component';

describe('ListCreatedQuizzesComponent', () => {
  let component: ListCreatedQuizzesComponent;
  let fixture: ComponentFixture<ListCreatedQuizzesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCreatedQuizzesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCreatedQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
