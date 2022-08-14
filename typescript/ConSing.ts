type SomeObject = any;
// ---cut---
type SomeConstructor = {
  new (s: string): SomeObject;
};
function fn(ctor: SomeConstructor) {
  return new ctor("hello");
}
class Human
{
    name : string;
    constructor(name)
    {
        console.log("Human constructor called");
        this.name = name;
    }
}
let h1 = fn(Human);
console.log("H1 ",h1);