

const fs = require('fs');
// 파일 비동기 처리 순서 제어
// #1. 콜백함수 중첩
fs.readFile('./text1.txt', (error, data) => {
   if (error) { throw error; }
   console.log("1번");
   console.log(data.toString());

   fs.readFile('./text2.txt', (error, data) => {
      if (error) { throw error; }
      console.log("2번");
      console.log(data.toString());

      fs.readFile('./text3.txt', (error, data) => {
         if (error) { throw error; }
         console.log("3번");
         console.log(data.toString());
      })
   })
})

