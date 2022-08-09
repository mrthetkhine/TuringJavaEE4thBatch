function display(obj:{
    name: string,
    age?: number
})
{
    console.log("Name is ",obj.name, "Age is ",obj.age);
}
display({
    name: "Hello"
});
display({
    name: "Tk",
    age : 37
});