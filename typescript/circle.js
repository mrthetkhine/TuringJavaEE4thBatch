var Circle = /** @class */ (function () {
    function Circle(radius) {
        this._radius = radius;
    }
    Object.defineProperty(Circle.prototype, "area", {
        get: function () {
            return Math.PI * this._radius * this._radius;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Circle.prototype, "radius", {
        set: function (newValue) {
            this._radius = newValue;
        },
        enumerable: false,
        configurable: true
    });
    return Circle;
}());
var c = new Circle(3);
c.radius = 20;
console.log("area ", c.area);
