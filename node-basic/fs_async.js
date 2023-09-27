
const fs = require('fs');
const fs_promise = fs.promises;

// #3. async / await 사용
async function main(){
   let data = await fs_promise.readFile('./text1.txt');
   console.log("1번");
   console.log(data.toString());

   let data2 = await fs_promise.readFile('./text2.txt');
   console.log("2번");
   console.log(data2.toString());

   let data3 = await fs_promise.readFile('./text3.txt');
   console.log("3번");
   console.log(data3.toString());
}
main();



