function fn(ctor) {
    return new ctor("hello");
}
var Human = /** @class */ (function () {
    function Human(name) {
        console.log("Human constructor called");
        this.name = name;
    }
    return Human;
}());
var h1 = fn(Human);
console.log("H1 ", h1);
