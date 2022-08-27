import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
@Component({
  selector: 'app-reactive-form-demo',
  templateUrl: './reactive-form-demo.component.html',
  styleUrls: ['./reactive-form-demo.component.scss']
})
export class ReactiveFormDemoComponent implements OnInit {

  movieForm = new FormGroup({
    name: new FormControl('',[
      Validators.required,
      Validators.minLength(4)
    ]),
    year: new FormControl(''),
    director: new FormControl(''),
  });

  constructor() { }

  ngOnInit(): void {
  }
  formSubmit()
  {
    console.log('MovieName ',this.movieForm.value);
    //console.log('Year ',this.year.value);
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
