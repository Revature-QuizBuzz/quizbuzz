import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NgForm } from '@angular/forms'; 

import { NewTagsComponent } from './new-tags.component';

describe('NewTagsComponent', () => {
  let component: NewTagsComponent;
  let fixture: ComponentFixture<NewTagsComponent>;
  const testForm = <NgForm>{
    name: "Not Java"
  };
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

  it('should return null',()=>{
    expect(component.onSubmit(testForm)).toBe();
  });
  
});
