function padLeft(padding: number | string, input: string): string {
    if(typeof padding === 'number')
    {
        return " ".repeat(padding) + input;
    }
    return padding+input;
}

let data = padLeft(5,"hello");
console.log("Data ",data);

data = padLeft("<<<","hello");
console.log("Data ",data);