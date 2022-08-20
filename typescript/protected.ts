class Base {
  protected m = 10;
}
class Derived extends Base {
    private name = "You cannot access";
  // No modifier, so default is 'public'
  m = 15;
}
const d = new Derived();
console.log(d.m); // OK
console.log("Private ",d["name"]);