import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-question-item',
  templateUrl: './question-item.component.html',
  styleUrls: ['./question-item.component.scss']
})
export class QuestionItemComponent implements OnInit {

  @Input() question:string = '';
  constructor() { }

  ngOnInit(): void {
  }

}
