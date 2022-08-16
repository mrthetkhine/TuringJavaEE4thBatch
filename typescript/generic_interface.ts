interface Box<Type>{
    contents: Type;
}
let b : Box<string> = {
    contents : "Hello"
}
console.log("B contents ",b.contents)