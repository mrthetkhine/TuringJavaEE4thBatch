var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Box = /** @class */ (function () {
    function Box() {
        this.contents = "";
    }
    Box.prototype.set = function (value) {
        this.contents = value;
        return this;
    };
    return Box;
}());
var ClearableBox = /** @class */ (function (_super) {
    __extends(ClearableBox, _super);
    function ClearableBox() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ClearableBox.prototype.clear = function () {
        this.contents = "";
    };
    return ClearableBox;
}(Box));
var a = new ClearableBox();
var b = a.set("hello");
b.clear();
