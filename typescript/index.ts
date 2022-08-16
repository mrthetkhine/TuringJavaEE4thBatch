interface StringArray {
  [index: number]: string;
}
 
const myArray: StringArray = ["Hello","How are you"];
const secondItem = myArray[1];

console.log("Second Item ",secondItem);