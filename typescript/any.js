function f1(a) {
    a.b(); // OK
}
function f2(a) {
    a.b();
}
f1({
    b: function () {
        console.log("B");
    }
});
f2({
    b: function () {
        console.log("B");
    }
});
