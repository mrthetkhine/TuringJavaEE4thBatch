interface StringArray {
    [index: number]: string;
    length: number;
    user: string;
}
const myArray: StringArray = {
    "0":"One",
    "1":"Two",
    length:2,
    user : "Something"
}
const secondItem = myArray[1];
console.log('Second Item ',secondItem);
console.log("User ",myArray.user);

interface NumberOrStringDictionary {
    [index: string]: number | string;
    length: number; // ok, length is a number
    name: string; // ok, name is a string
}
const numberOrStringDict : NumberOrStringDictionary ={
    "0":"One",
    "1":"Two",
    length : 2,
    name :"Something"
};
console.log("Number or string ",numberOrStringDict["1"]);