import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieListPageComponent } from './movie-list-page.component';

describe('MovieListPageComponent', () => {
  let component: MovieListPageComponent;
  let fixture: ComponentFixture<MovieListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieListPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
