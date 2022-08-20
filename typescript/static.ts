class MyClass {
  //static name;
  static x =10;
  static printX() {
    console.log(MyClass.x);
  }
  static{
    console.log("Static block executed");
  }
}
console.log(MyClass.x);
MyClass.printX();