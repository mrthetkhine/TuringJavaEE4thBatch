import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-movie-detail-page',
  templateUrl: './movie-detail-page.component.html',
  styleUrls: ['./movie-detail-page.component.scss']
})
export class MovieDetailPageComponent implements OnInit {
  movieId!:string ;
  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.movieId =   String(this.route.snapshot.paramMap.get('id'));
    console.log('Movie Id ',this.movieId);
  }

}
