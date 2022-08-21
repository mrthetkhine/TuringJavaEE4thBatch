import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent implements OnInit {

  @Input("data") value:number =0;

  constructor() { }
  ngOnChanges()
  {
    console.log('Child ngOnChange ',this.value);
  }
  ngOnInit(): void {
  }

}
