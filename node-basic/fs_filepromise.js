
const fs = require('fs');
const fs_promise = fs.promises;

// #2. 파일 프로미스 사용
fs_promise.readFile('./text1.txt')
   .then((data) => {
      console.log("1번");
      console.log(data.toString());
      return fs_promise.readFile('./text2.txt');
   })
   .then((data) => {
      console.log("2번");
      console.log(data.toString());
      return fs_promise.readFile('./text3.txt');
   })
   .then((data) => {
      console.log("3번");
      console.log(data.toString());
   })
   .catch(error => {
      throw error;
   });



