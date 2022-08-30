import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';
import {Movie} from "../../model/movie.model";

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})
export class MovieListComponent implements OnInit {

  @Input() movies = new Array<Movie>();
  @Output() editClickEvent = new EventEmitter<number>();
  @Output() deleteClickEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }
  btnEditClick(index:number)
  {
    this.editClickEvent.emit(index);
  }
  btnDeleteClick(index:number)
  {
    this.deleteClickEvent.emit(index);
  }
}
