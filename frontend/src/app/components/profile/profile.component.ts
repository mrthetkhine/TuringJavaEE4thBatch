import {Component, Input, OnInit, Output,EventEmitter} from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  @Input() name:string ='';
  @Output() nameClick = new EventEmitter<string>();
  constructor() { }

  ngOnInit(): void {
  }
  onClick()
  {
    console.log("Profile ",this.name, " Click");
    this.nameClick.emit(this.name);
  }

}
