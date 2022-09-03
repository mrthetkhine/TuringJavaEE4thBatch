import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';
import {Movie} from "../../model/movie.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})
export class MovieListComponent implements OnInit {

  @Input() movies = new Array<Movie>();
  @Output() editClickEvent = new EventEmitter<number>();
  @Output() deleteClickEvent = new EventEmitter<number>();

  constructor( private router: Router) { }

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
  btnDetailClick(index:number)
  {
    console.log("Btn Movie Detail Click",index);
    this.router.navigate(['/movies/'+index]).then(data=>{
      console.log("After navigated");
    });
  }
}
