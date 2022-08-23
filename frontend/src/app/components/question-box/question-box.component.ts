import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';

@Component({
  selector: 'app-question-box',
  templateUrl: './question-box.component.html',
  styleUrls: ['./question-box.component.scss']
})
export class QuestionBoxComponent implements OnInit {
  @Input() value = '';
  @Output() addItemEvent = new EventEmitter<string>();
  @Output() updateItemEvent = new EventEmitter<string>();

  updateDisabled = false;
  constructor() { }

  ngOnInit(): void {
  }
  btnAddClick(newItem:string)
  {
    this.addItemEvent.emit(newItem);
  }
  btnUpdateClick(updateItem:string)
  {
    this.updateItemEvent.emit(updateItem);
  }
}
