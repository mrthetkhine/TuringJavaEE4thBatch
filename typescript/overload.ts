function hello(n:string):any;
function hello(n:string,k:number):any;
function hello(n:string,k?:number):any
{
    console.log("Hello function ",n, " K ",k);
}
hello("29");
hello("Hello",10);