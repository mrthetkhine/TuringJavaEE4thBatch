interface Type{
    name : string
};
interface Type2{
    name : string,
    age : number
};
let data : Type = {
    name : "TK"
};
//let data2: Type2 = data;
//console.log('Data2 ',data2);
let data2 : Type2 = {
    name : "Tk",
    age : 37
};
let data1 : Type = data2;