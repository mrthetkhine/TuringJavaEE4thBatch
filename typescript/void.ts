type voidFunc = () => void;
 
const f1: voidFunc = () => {
  return 100;
};
 
const f2: voidFunc = () => true;
 
const f3: voidFunc = function () {
  return "true";
};
let x = f1();
console.log("Type of x ",typeof x);
//x ++;

function f4(): void {
    // @ts-expect-error
    return true;
}