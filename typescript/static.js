var MyClass = /** @class */ (function () {
    function MyClass() {
    }
    MyClass.printX = function () {
        console.log(MyClass.x);
    };
    //static name;
    MyClass.x = 10;
    (function () {
        console.log("Static block executed");
    })();
    return MyClass;
}());
console.log(MyClass.x);
MyClass.printX();
