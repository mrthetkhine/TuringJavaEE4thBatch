function move(animal) {
    if ("swim" in animal) {
        return animal.swim();
    }
    return animal.fly();
}
move({
    fly: function () {
        console.log("Fly");
    }
});
function logValue(x) {
    if (x instanceof Date) {
        console.log(x.toUTCString());
    }
    else {
        console.log(x.toUpperCase());
    }
}
logValue(new Date());
