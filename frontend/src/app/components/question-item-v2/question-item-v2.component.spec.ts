import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionItemV2Component } from './question-item-v2.component';

describe('QuestionItemV2Component', () => {
  let component: QuestionItemV2Component;
  let fixture: ComponentFixture<QuestionItemV2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionItemV2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuestionItemV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
