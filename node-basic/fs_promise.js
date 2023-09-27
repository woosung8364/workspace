
const fs = require('fs');

const fs_promise = fs.promises; // require('fs').promises
// 파일 프로미스 메서드
const promise = fs_promise.readFile('./text1.txt')
   promise.then((data) => {
      console.log(data); // <Buffer eb ...> : 버퍼 (16진수로 변환된 바이트 데이터 저장)
      console.log('toString 부분 : ' ,data.toString()); // 디코딩
   })
   .catch((error) => {
      throw error;
   })

// util 모듈을 이용한 프로미스 변환
const util = require('util');
const fs_util_read = util.promisify(fs.readFile); // 노드메서드를 프로미스화

fs_util_read('./text1.txt')
   .then((data) => {
      console.log(data);
      console.log(data.toString());
   })
   .catch((error) => {
      throw error;
   })


   