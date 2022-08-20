class Animal {
    name = "Animal";
  move() {
    console.log("Moving along!");
  }
}
 
class Dog extends Animal {
  woof(times: number) {
    for (let i = 0; i < times; i++) {
      console.log("woof!");
    }
  }
  move() {
    console.log("Dog moving along!");
  }
}
 
const d = new Dog();
// Base class method
d.move();
// Derived class method
d.woof(3);
console.log("Name ",d.name);