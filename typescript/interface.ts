interface Animal
{
    name:string;
}
interface Bear extends Animal
{
    honey: string;
}
let data :Bear = {
    name : "Bear1",
    honey: "None"
}
console.log("Data ",data);