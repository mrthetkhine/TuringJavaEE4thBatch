import { Component, OnInit } from '@angular/core';
import {MovieService} from "../../service/movie.service";

@Component({
  selector: 'app-movie-counter',
  templateUrl: './movie-counter.component.html',
  styleUrls: ['./movie-counter.component.scss']
})
export class MovieCounterComponent implements OnInit {

  movieCounter = 0;
  subscriber;
  constructor(private movieService:MovieService) {

    this.subscriber = this.movieService.movies.subscribe(movies=>{
      console.log("Movie change in movie counter");
      this.movieCounter = movies.length;
    });
  }

  ngOnInit(): void {
  }
  ngOnDestroy()
  {
    this.subscriber.unsubscribe();
  }
}
