class Shape
{
    constructor()
    {
        console.log("Shape Constructor");
    }
    draw()
    {
        console.log("Shape Draw");
    }
}
let n : string ;
class Circle extends Shape
{
    n : number;
    constructor()
    {
        super();
        console.log("Circle Constructor");
    }
    draw()
    {
        super.draw();
        console.log("Circle Draw");
        this.n = 21;
    }
}
let x = new Circle();
x.draw();