
const fs = require('fs');
const fs_promise = fs.promises;

// 파일 쓰고, 읽기
fs_promise.writeFile('./text3.txt', "행복한 하루 되세요")
   .then(() => {
      return fs_promise.readFile('./text3.txt');
   })
   .then((data) => {
      console.log(data.toString()); //행복한 하루 되세요
   })
   .catch((error) => {
      console.log("파일 입출력 도중 오류 발생 : " + error);
   })

