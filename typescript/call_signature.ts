type DescribableFunction = {
  description: string;
  (someArg: number): boolean;
};
function doSomething(fn: DescribableFunction) {
  console.log(fn.description + " returned " + fn(6));
}
function isEven(n:number)
{
    return n %2 ==0;
}
isEven.description = "Function Double";
doSomething(isEven);