type MyFunc = ()=>void;

function hello(func:MyFunc)
{

}
function hi()
{
    console.log("Hi");
}
hello(hi);

function add(a:number,b:number)
{
    return a+b;
}
//hello(add);

type BinaryFunc = (x:number,y:number)=>number;

let func : BinaryFunc = add;