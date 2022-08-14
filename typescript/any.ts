function f1(a: any) {
  a.b(); // OK
}
function f2(a: unknown) {
  a.b();
}
f1({
    b()
    {
        console.log("B");
    }
})
f2({
    b()
    {
        console.log("B");
    }
})