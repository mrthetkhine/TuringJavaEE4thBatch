function greet(name:string)
{
    console.log("How are you ",name);
}
let data = greet("Mg Mg");
//greet(1);
console.log("Data ",data);

function add(a:number,b:number):number
{
    return a+b;
}

let num  = add(1,2);
console.log("Num ",num);

let everything :any = {
    valueOf:function()
    {
        console.log("Value of");
        return {};
    },
    toString:function()
    {
        console.log("To String of");
        return 4;
    }
};
let something = everything + num;

console.log("Something ", something);
console.log("typeof something ",typeof something);