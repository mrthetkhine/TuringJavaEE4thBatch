const fs = require('fs');

fs.readFile('./hello.txt', 'utf8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log('file read data ',data);
});
console.log('Next line after read file');