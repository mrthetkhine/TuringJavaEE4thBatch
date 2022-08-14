function firstElement(arr) {
    return arr[0];
}
var s = firstElement(["a", "b", 10]);
console.log("type of s ", typeof s);
//s = 10;
function map(arr, func) {
    return arr.map(func);
}
// Parameter 'n' is of type 'string'
// 'parsed' is of type 'number[]'
var parsed = map(["1", "2", "3"], function (n) { return parseInt(n); });
console.log("Parsed ", parsed);
