function doSomething(fn) {
    console.log(fn.description + " returned " + fn(6));
}
function isEven(n) {
    return n % 2 == 0;
}
isEven.description = "Function Double";
doSomething(isEven);
