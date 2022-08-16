interface Box{
  contents: unknown;
}
 
let x: Box = {
  contents: "hello world",
};
 console.log((x.contents as string).toLowerCase());