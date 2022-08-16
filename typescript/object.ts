type Address ={
    readonly homeNo :string;
    street:string;
}
type Human = {
    readonly name : string;
    age : number;
    phone?:string;
    readonly address : Address
}
let h : Human = {
    name : "TK",
    age : 20,
    /*phone : "2000"*/
    address: {
        homeNo : "somewhere",
        street : "Some street"
    }
};
//h.name = "Another";
/*
h.address = {

}*/
//h.address.homeNo = "Change";
console.log("h ",h);
