import { Component, OnInit,TemplateRef } from '@angular/core';
import {FormControl, FormGroup, Validators,FormBuilder} from '@angular/forms';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import {Movie} from "../../model/movie.model";
import {MovieService} from "../../service/movie.service";
@Component({
  selector: 'app-reactive-form-demo',
  templateUrl: './reactive-form-demo.component.html',
  styleUrls: ['./reactive-form-demo.component.scss']
})
export class ReactiveFormDemoComponent implements OnInit {

  modalRef?: BsModalRef;
  movieForm;
  movies: Array<Movie> = [];
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
      year: ['',[Validators.required, Validators.pattern("^[0-9]*$"),]],
      director: ['',[Validators.required]]
    });
    this.movieService.movies.subscribe(movies=>{
      console.log('Data movie changes ',movies);
      this.movies = movies;
    });
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
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
  editMovie(index:number)
  {
    console.log("Edit Movie ",this.movies[index]);
  }
  formSubmit()
  {
    console.log('MovieName ',this.movieForm.value);
    //console.log('Year ',this.year.value);
    let movie = {...this.movieForm.value};

    this.movieService.addMovie(movie);
    this.modalRef?.hide();
    this.movieForm.reset();
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
