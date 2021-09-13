import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateQuizesComponent } from './create-quizes.component';

describe('CreateQuizesComponent', () => {
  let component: CreateQuizesComponent;
  let fixture: ComponentFixture<CreateQuizesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateQuizesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateQuizesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
