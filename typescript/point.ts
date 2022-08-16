class Point {
  x: number;
  y: number;

  constructor(x,y)
  {
    this.x = x;
    this.y = y;
    console.log("Constructor");
  }
}
 
const pt = new Point(10,20);
//pt.x = 0;
//pt.y = 0;

console.log("Pt ",pt);