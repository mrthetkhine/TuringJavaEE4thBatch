function getOrNot(y, x, z) {
    console.log("Get or not ", x, " y ", y);
}
getOrNot("hi");
getOrNot("hello", "how are you");
function fun(x) {
    if (x === void 0) { x = 10; }
    console.log("Fun default ", x);
}
fun();
fun(100);
fun(undefined);
