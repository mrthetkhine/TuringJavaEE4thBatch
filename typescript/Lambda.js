(function () {
    console.log("How are you ");
})();
//Immediately Invoking Function expression.
var nums = [1, 2, 3, 4];
var double = nums.map(function (x) { return x * 2; });
console.log("Double ", double);
var times = function (x) {
    return x * 2;
};
double = nums.map(times);
console.log("Double ", double);
