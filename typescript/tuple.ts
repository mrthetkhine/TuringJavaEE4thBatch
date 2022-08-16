type Tuple = [string,number,number];
let x : Tuple = ["Hello",12,13];
console.log("x ",x[1]);


function getResult():[any,string]
{
    return [Error("Custom"),""];
}
let [error,result] = getResult();
console.log("Data ",error, "Result");