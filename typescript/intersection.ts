type Animal={
    name:string;
}
type Bear = Animal & {
    honey: string;
}
let data :Bear  = {
    name : "Bear1",
    honey : "None"
};
console.log("Intersection type ",data);