var Sonar = /** @class */ (function () {
    function Sonar() {
        this.x = 10;
    }
    Sonar.prototype.check = function (str) {
        console.log("ping!", str.toLowerCase());
    };
    return Sonar;
}());
var sonar = new Sonar();
sonar.check("Hello");
console.log("X ", sonar.x);
