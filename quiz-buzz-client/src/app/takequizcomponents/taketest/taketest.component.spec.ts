import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaketestComponent } from './taketest.component';

describe('TaketestComponent', () => {
  let component: TaketestComponent;
  let fixture: ComponentFixture<TaketestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaketestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaketestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
