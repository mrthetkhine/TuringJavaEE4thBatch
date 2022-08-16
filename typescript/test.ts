type Fish = { swim: () => void };
type Bird = { fly: (flyable: string) => string };
type Human = {
    name: string;
    run: () => void
};
function Animal(arg: Fish | Bird | Human, nameofBird?: string) {
    if ("swim" in arg) {
        return arg.swim();
    } else if ("fly" in arg) {
        if(nameofBird)
        {
            let result: string = arg.fly(nameofBird);
            console.log(result);
        }
       
    } else {
        return arg.run();
    }
}
Animal({
    fly() {
        console.log("I can fly")
        return "Hello I'm a bird";
    }
},
    "pigeon"
);
Animal({
    name: "Kaung",
    run() {
        console.log("I'm human and I can run");
    }
},
    "");