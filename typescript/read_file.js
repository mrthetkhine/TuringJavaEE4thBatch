const fs = require('fs');
let start = new Date();

let data = fs.readFile('hello.txt',(err,data)=>{
    console.log('Readfile data ',data);
});
console.log('After read file ',data);