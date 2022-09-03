import {Component, NgZone, OnChanges, OnInit} from '@angular/core';

@Component({
  selector: 'app-change-detection-demo',
  templateUrl: './change-detection-demo.component.html',
  styleUrls: ['./change-detection-demo.component.scss']
})
export class ChangeDetectionDemoComponent implements OnInit,OnChanges {

  current= new Date();
  constructor(private ngZone: NgZone) {
    this.ngZone.runOutsideAngular(()=>{
      setInterval(()=>{
        this.current = new Date();
      },1000);
    });
    /**/
  }

  ngOnInit(): void {
  }
  ngOnChanges()
  {
    console.log('OnChange event');
  }
  ngDoCheck() {
    console.log("ChangeDetectionDemoComponent ngDoCheck");
  }
  /*
  ngAfterContentInit() {
    console.log("ChangeDetectionDemoComponent ngAfterContentInit");
  }

  ngAfterContentChecked() {
    console.log("ChangeDetectionDemoComponent ngAfterContentChecked");
  }

  ngAfterViewInit() {
    console.log("ChangeDetectionDemoComponent ngAfterViewInit");
  }

  ngAfterViewChecked()
  {
    console.log("ChangeDetectionDemoComponent ngAfterViewChecked");
  }*/
  onMouseOver($event:any)
  {


  }
}
