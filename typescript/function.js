function greet(name) {
    console.log("How are you ", name);
}
var data = greet("Mg Mg");
//greet(1);
console.log("Data ", data);
function add(a, b) {
    return a + b;
}
var num = add(1, 2);
console.log("Num ", num);
var everything = {
    valueOf: function () {
        console.log("Value of");
        return {};
    },
    toString: function () {
        console.log("To String of");
        return 4;
    }
};
var something = everything + num;
console.log("Something ", something);
console.log("typeof something ", typeof something);
