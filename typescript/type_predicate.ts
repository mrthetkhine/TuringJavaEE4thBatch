type Fish = {
    swim :()=>void
}
type Bird = {
    fly:()=>void
}
function isFish(pet: Fish | Bird): pet is Fish {
  return (pet as Fish).swim !== undefined;
}

let myPet : Fish | Bird = {
    swim()
    {
        console.log("Fish swim");
    }
}
myPet = {
    fly()
    {
        console.log("Fly");
    }
}
if( isFish(myPet))
{
    myPet.swim();
}
else
{
    myPet.fly();
}