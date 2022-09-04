import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Movie} from "../../model/movie.model";
import {MovieService} from "../../service/movie.service";

@Component({
  selector: 'app-movie-detail-page',
  templateUrl: './movie-detail-page.component.html',
  styleUrls: ['./movie-detail-page.component.scss']
})
export class MovieDetailPageComponent implements OnInit {
  movieId!:string ;
  movie:Movie;
  constructor(private route:ActivatedRoute,
              private movieService : MovieService) { }

  ngOnInit(): void {
    this.movieId =   String(this.route.snapshot.paramMap.get('id'));
    console.log('Movie Id ',this.movieId);
    this.movie = this.movieService.getMovieById(this.movieId);
  }

}
