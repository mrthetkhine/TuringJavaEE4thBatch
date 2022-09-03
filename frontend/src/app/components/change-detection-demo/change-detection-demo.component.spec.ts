import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeDetectionDemoComponent } from './change-detection-demo.component';

describe('ChangeDetectionDemoComponent', () => {
  let component: ChangeDetectionDemoComponent;
  let fixture: ComponentFixture<ChangeDetectionDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeDetectionDemoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangeDetectionDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
