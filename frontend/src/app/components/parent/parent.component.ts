import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
export class ParentComponent implements OnInit {
  data = 100;
  names = ["one","two","three"];
  currentName:string = '';
  constructor() { }

  ngOnInit(): void {
    this.currentName = this.names[0];
  }
  onClick()
  {
    this.data ++;
  }
  childNameClick(name:string)
  {
    this.currentName = name;
  }
}
