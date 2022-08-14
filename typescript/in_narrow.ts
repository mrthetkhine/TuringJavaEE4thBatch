
type Fish = { swim: () => void };
type Bird = { fly: () => void };
 
function move(animal: Fish | Bird) {
  if ("swim" in animal) {
    return animal.swim();
  }
 
  return animal.fly();
}
move({
    fly()
    {
        console.log("Fly");
    }
});

function logValue(x: Date | string) {
    if (x instanceof Date) {
      console.log(x.toUTCString());
                 
    } else {
      console.log(x.toUpperCase());
    }
}
logValue(new Date());