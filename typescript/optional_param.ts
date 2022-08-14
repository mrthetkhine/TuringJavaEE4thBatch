function getOrNot(y:string,x?:string, z?:string)
{
    console.log("Get or not ",x, " y ",y);
}
getOrNot("hi");
getOrNot("hello","how are you");

function fun(x = 10)
{
    console.log("Fun default ",x);
}
fun();
fun(100);
fun(undefined);