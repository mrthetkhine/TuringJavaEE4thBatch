import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {FormControl, FormGroup, Validators,FormBuilder} from '@angular/forms';

import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import Swal from 'sweetalert2';
import {Movie} from "../../model/movie.model";
import {MovieService} from "../../service/movie.service";
@Component({
  selector: 'app-reactive-form-demo',
  templateUrl: './reactive-form-demo.component.html',
  styleUrls: ['./reactive-form-demo.component.scss']
})
export class ReactiveFormDemoComponent implements OnInit {

  @ViewChild('template') template:any = null;
  modalRef?: BsModalRef;
  movieForm;
  movies: Array<Movie> = [];
  editMode = false;
  /*
  movieForm = new FormGroup({
    name: new FormControl('',[
      Validators.required,
      Validators.minLength(4)
    ]),
    year: new FormControl(''),
    director: new FormControl(''),
  });
  */
  constructor(private formBuilder: FormBuilder,
              private modalService: BsModalService,
              private movieService:MovieService) {
    this.movieForm = this.formBuilder.group({
      id:[''],
      name : ['',[
        Validators.required,
        Validators.minLength(4)
      ]],
      year: [0,[Validators.required, Validators.pattern("^[0-9]*$"),]],
      director: ['',[Validators.required]]
    });
    this.movieService.movies.subscribe(movies=>{
      console.log('Data movie changes ',movies);
      this.movies = movies;
    });
  }
  newMovieClick()
  {
    this.editMode = false;
    this.movieForm.reset();
    this.openModal(this.template);
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  closeMovieModal()
  {
    this.modalRef?.hide();
  }

  ngOnInit(): void {
  }
  keyPress(event: any) {
    const pattern = /[0-9\+\-\ ]/;

    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
  }
  editBtnClick(index:number)
  {
    console.log("Edit Movie ",this.movies[index]);
    let movie = this.movies[index];
    this.movieForm.patchValue({...movie});
    this.editMode = true;
    this.modalRef = this.modalService.show(this.template);
  }
  showDeleteMovieDialog(movieName:string)
  {
    return Swal.fire({
      title: 'Are you sure you want to delete '+movieName+' ?',
      /* text: "You won't be able to revert this!",*/
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    })
  }
  btnDeleteMovieClick(index:number)
  {
    let movie = this.movies[index];
    console.log('Delete movie ',movie);
    this.showDeleteMovieDialog(movie.name).then((result) => {
      if (result.isConfirmed) {
        this.deleteMovie(index);
      }
    })
  }

  private deleteMovie(index:number) {
    this.movieService.deleteMovie(index);
    Swal.fire(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
  }

  saveOrUpdateMovie()
  {
    let movie = this.movieForm.value as Movie;
    if(this.editMode == false)
    {
      console.log('MovieName ',this.movieForm.value);
      //console.log('Year ',this.year.value);
      this.movieService.addMovie(movie);
      this.movieForm.reset();
    }
    else
    {
      console.log('Update Movie');
      this.movieService.updateMovie(movie);
    }
    this.modalRef?.hide();
  }
  updateName()
  {
    //this.movieName.setValue("Update Name");
  }
  get movieFormControl()
  {
    return this.movieForm.controls;
  }
}
