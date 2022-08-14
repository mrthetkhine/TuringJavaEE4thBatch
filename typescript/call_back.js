function callBackend(fun)
{
    setTimeout(()=>{
        console.log("1000 ");
        return fun(1000);
    },1000);
}
function callback(k)
{
    console.log("K ",k);
}
callBackend(callback);
console.log("Hello");