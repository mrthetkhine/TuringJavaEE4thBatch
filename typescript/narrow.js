function padLeft(padding, input) {
    if (typeof padding === 'number') {
        return " ".repeat(padding) + input;
    }
    return padding + input;
}
var data = padLeft(5, "hello");
console.log("Data ", data);
data = padLeft("<<<", "hello");
console.log("Data ", data);
