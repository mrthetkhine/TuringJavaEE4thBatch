import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-question-item-v2',
  templateUrl: './question-item-v2.component.html',
  styleUrls: ['./question-item-v2.component.scss']
})
export class QuestionItemV2Component implements OnInit {

  @Input() question:string = '';
  @Input() index:number = 0;
  @Output() newQuestionEvent = new EventEmitter<any>();
  constructor() { }

  ngOnInit(): void {
  }
  questionClickHandler()
  {

    this.newQuestionEvent.emit({
      question:this.question,
      index: this.index
    });
  }

}
