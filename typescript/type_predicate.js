function isFish(pet) {
    return pet.swim !== undefined;
}
var myPet = {
    swim: function () {
        console.log("Fish swim");
    }
};
myPet = {
    fly: function () {
        console.log("Fly");
    }
};
if (isFish(myPet)) {
    myPet.swim();
}
else {
    myPet.fly();
}
