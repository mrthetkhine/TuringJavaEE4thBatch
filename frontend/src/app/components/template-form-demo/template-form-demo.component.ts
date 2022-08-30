import { Component, OnInit } from '@angular/core';
import {Movie} from "../../model/movie.model";

@Component({
  selector: 'app-template-form-demo',
  templateUrl: './template-form-demo.component.html',
  styleUrls: ['./template-form-demo.component.scss']
})
export class TemplateFormDemoComponent implements OnInit {

  model = new Movie('1','Movie 1',2003,'Director 1');
  submitted = false;

  constructor() { }
  ngOnInit(): void {
  }
  onSubmit() { this.submitted = true; }
  showName()
  {
    console.log("Movie name ",this.model.name);
  }
  setName()
  {
    this.model.name = "Change"
  }
}
