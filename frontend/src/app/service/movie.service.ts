import { Injectable } from '@angular/core';
import {Movie} from "../model/movie.model";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  _movieArr:Array<Movie> = [];
  _movies  = new BehaviorSubject<Movie[]>([]);
  readonly movies = this._movies.asObservable();
  constructor() {
    this._movieArr.push(new Movie("1","Titanic",2015,"Jame Cameron"));
    this._movieArr.push(new Movie("2","Titanic2",2015,"Jame Cameron"));

    this._movies.next(this._movieArr);
  }

  addMovie(movie:any)
  {
    this._movieArr.push(movie);
    this._movies.next(this._movieArr);
  }
  getAllMovie()
  {
    return this.movies;
  }
}
