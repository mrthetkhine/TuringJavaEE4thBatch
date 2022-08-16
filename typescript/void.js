var f1 = function () {
    return 100;
};
var f2 = function () { return true; };
var f3 = function () {
    return "true";
};
var x = f1();
console.log("Type of x ", typeof x);
//x ++;
function f4() {
    // @ts-expect-error
    return true;
}
