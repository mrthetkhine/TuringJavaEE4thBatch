let obj = {
    name : "TK",
    display : function()
    {
        console.log("Display ",this.name);
    }
};
let obj2 = {
    name : "TK2",
}
obj.display();
let dis = obj.display;
dis();

dis = obj.display.bind(obj2);
dis();

obj.display.call(obj2);
obj.display.apply(obj2,[]);