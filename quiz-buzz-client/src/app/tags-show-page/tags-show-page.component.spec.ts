import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagsShowPageComponent } from './tags-show-page.component';

describe('TagsShowPageComponent', () => {
  let component: TagsShowPageComponent;
  let fixture: ComponentFixture<TagsShowPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TagsShowPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TagsShowPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
