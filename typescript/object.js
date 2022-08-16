var h = {
    name: "TK",
    age: 20,
    /*phone : "2000"*/
    address: {
        homeNo: "somewhere",
        street: "Some street"
    }
};
//h.name = "Another";
/*
h.address = {

}*/
h.address.homeNo = "Change";
console.log("h ", h);
