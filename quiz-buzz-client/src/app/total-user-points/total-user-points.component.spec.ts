import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalUserPointsComponent } from './total-user-points.component';

describe('TotalUserPointsComponent', () => {
  let component: TotalUserPointsComponent;
  let fixture: ComponentFixture<TotalUserPointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalUserPointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalUserPointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
