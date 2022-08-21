import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.scss']
})
export class HelloWorldComponent implements OnInit {

  data = 100;

  constructor() {
    console.log('HelloWorldComponent created');
  }

  ngOnChanges() {
    console.log('HelloWorld ngOnChange');
  }

  ngOnInit(): void {
    console.log("HelloWorld ngOnInit");
  }

  ngDoCheck() {
    console.log("HelloWorld ngDoCheck");
  }

  ngAfterContentInit() {
    console.log("HelloWorld ngAfterContentInit");
  }

  ngAfterContentChecked() {
    console.log("HelloWorld ngAfterContentChecked");
  }

  ngAfterViewInit() {
    console.log("HelloWorld ngAfterViewInit");
  }

  ngAfterViewChecked()
  {
    console.log("HelloWorld ngAfterViewChecked");
  }
  ngOnDestroy()
  {
    console.log("HelloWorld ngOnDestroy");
  }
  onClick()
  {
    this.data ++;
  }
}
