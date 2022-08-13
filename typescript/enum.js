var DIRECTION;
(function (DIRECTION) {
    DIRECTION["UP"] = "UP";
    DIRECTION["DOWN"] = "DOWN";
    DIRECTION[DIRECTION["NORTH"] = 1] = "NORTH";
})(DIRECTION || (DIRECTION = {}));
var dir = DIRECTION.UP;
console.log("Dir ", dir);
dir = DIRECTION.NORTH;
console.log("Dir ", dir);
