import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question-container',
  templateUrl: './question-container.component.html',
  styleUrls: ['./question-container.component.scss']
})
export class QuestionContainerComponent implements OnInit {

  currentQuestion = '';
  currentQuestionIndex = 0;
  questions:Array<string> = [];
  constructor() {

  }

  ngOnInit(): void {
    console.log("Question length ",this.questions.length)
  }
  addItem(newItem: string)
  {
    console.log('Event fired ',newItem);
    this.questions.push(newItem);
  }
  questionClicked(event:any)
  {
    console.log('Parent question clicked ',event.question, " Index ",event.index);
    this.currentQuestion = event.question;
    this.currentQuestionIndex = event.index;
  }
  updateItem(updateItem:string)
  {
    this.questions[this.currentQuestionIndex] = updateItem;
  }
}
