var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
        console.log("Constructor");
    }
    return Point;
}());
var pt = new Point(10, 20);
//pt.x = 0;
//pt.y = 0;
console.log("Pt ", pt);
