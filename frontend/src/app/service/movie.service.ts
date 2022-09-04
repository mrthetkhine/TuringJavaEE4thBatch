import { Injectable } from '@angular/core';
import {Movie} from "../model/movie.model";
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../Config/Config";
import Swal from "sweetalert2";

const API  = API_URL+"movies";
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  _movieArr:Array<Movie> = [];
  _movies  = new BehaviorSubject<Movie[]>([]);
  readonly movies = this._movies.asObservable();

  constructor(private http: HttpClient) {
    /*
    this._movieArr.push(new Movie("1","Titanic",2015,"Jame Cameron"));
    this._movieArr.push(new Movie("2","Titanic2",2015,"Jame Cameron"));
    this.emitChange();
    *
     */
    this.fetchAllMovie().subscribe(movies=>{
      this._movieArr = movies;
      this.emitChange();
    });
  }
  fetchAllMovie():Observable<Movie[]> {
    console.log("Fetch all movie Get ",API);
    return this.http.get<Movie[]>(API);
  }
  getMovieById(movieId:string):Movie
  {
    return this._movieArr.filter(m=>m.id===movieId)[0];
  }
  saveMovie(movie:Movie)
  {
    return this.http.post<Movie>(API,movie).subscribe(movie=>{
      this.addMovie(movie);
    });
  }

  private emitChange() {
    this._movies.next(this._movieArr);
  }

  addMovie(movie:Movie)
  {
    this._movieArr.push(movie);
    this.emitChange();
  }
  updateMovie(movie:Movie)
  {
    this.http.put<Movie>(API+"/"+movie.id,movie).subscribe(movie=>{
      this._updateMovie(movie);
    });
  }
  _updateMovie(movie:Movie)
  {
    this._movieArr = this._movieArr.map(m=>m.id== movie.id?movie: m);
    this.emitChange();
  }
  _deleteMovie(movie:Movie)
  {
    this._movieArr = this._movieArr.filter(m=>movie.id!=m.id);
    this.emitChange();
  }

  deleteMovie(movie:Movie,callback:()=>void )
  {
    this.http.delete<Movie>(API+"/"+movie.id).subscribe((m:Movie)=>{
      this._deleteMovie(movie);
      callback();
    });
  }
  getAllMovie()
  {
    return this.movies;
  }
}
