import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTagsComponent } from './new-tags.component';

describe('NewTagsComponent', () => {
  let component: NewTagsComponent;
  let fixture: ComponentFixture<NewTagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewTagsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
