(function()
{
    console.log("How are you ");
})();
//Immediately Invoking Function expression.

let nums = [1,2,3,4];
let double = nums.map(x=>x*2);
console.log("Double ",double);


let times = function(x){
    return x * 2;
};
double = nums.map(times);
console.log("Double ",double);