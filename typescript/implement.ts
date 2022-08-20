interface Pingable {
    x: number;
    y?:number;
  check(str:string): void;
}
 
class Sonar implements Pingable {
  x = 10;
  check(str:string) {
    console.log("ping!",str.toLowerCase());
  }
}
let sonar = new Sonar();
sonar.check("Hello");
console.log("X ",sonar.x);