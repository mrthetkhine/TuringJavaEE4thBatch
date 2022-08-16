var x = ["Hello", 12, 13];
console.log("x ", x[1]);
function getResult() {
    return [Error("Custom"), ""];
}
var _a = getResult(), error = _a[0], result = _a[1];
console.log("Data ", error, "Result");
