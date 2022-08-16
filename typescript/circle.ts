class Circle
{
    _radius : number;

    constructor(radius:number)
    {
        this._radius = radius;
    }
    get area()
    {
        return Math.PI * this._radius * this._radius;
    }
    set radius(newValue:number)
    {
        this._radius = newValue;
    }
}
let c = new Circle(3);
c.radius  = 20;
console.log("area ",c.area);