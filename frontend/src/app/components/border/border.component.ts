import {Component, ContentChild, OnInit} from '@angular/core';

@Component({
  selector: 'app-border',
  templateUrl: './border.component.html',
  styleUrls: ['./border.component.scss']
})
export class BorderComponent implements OnInit {

  expanded = true;
  constructor() { }

  ngOnInit(): void {
  }

}
