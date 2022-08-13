let data = null;
if(!data)
{
    console.log("Data is false ");
}


function getTrue()
{
    console.log("Get true");
    return true;
}
function getFalse()
{
    console.log("Get false");
    return false;
}
console.log(" false && true ", false && { name: "TK"});
console.log(" undefined && true ", undefined && { name: "TK"});
console.log(" 0 && true ", undefined && true);

console.log(" getFalse && getTrue", getFalse() && getTrue());

console.log(" getTrue && something", getTrue() && 'something');

console.log(" getTrue && {name:'something'}", getTrue() && {name:'something'});

console.log(" getFalse || {name:'something'}", getFalse() || {name:'something'});
console.log(" undefined || {name:'something'}", undefined || {name:'something'});
console.log(" getTrue || {name:'something'}", getTrue() || {name:'something'});
console.log(" {name:'something'} || false",{name:'something'} || false);