import {Component, OnInit, Output, EventEmitter, Input} from '@angular/core';
import {LoggerService} from "../../logger.service";

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
  haveBorder = true;
  constructor(private logService: LoggerService) { }

  ngOnInit(): void {
  }
  btnAddClick(newItem:string)
  {
    this.addItemEvent.emit(newItem);
    this.logService.log("new Item added")
  }
  btnUpdateClick(updateItem:string)
  {
    this.updateItemEvent.emit(updateItem);
  }
}
