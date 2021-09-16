import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteTagComponent } from './delete-tag.component';

describe('DeleteTagComponent', () => {
  let component: DeleteTagComponent;
  let fixture: ComponentFixture<DeleteTagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteTagComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteTagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
