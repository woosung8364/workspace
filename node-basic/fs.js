
// 파일에 내가 원하는 텍스트 쓰기
const fs = require('fs');

const data = '노드 파일 쓰기 TEST!';

//  비동기적 파일 쓰기
// writeFile('파일이름' , 쓸내용 , 인코딩 , 에러 콜백함수)
fs.writeFile('text1.txt', data, 'utf8', function (error) {
  if (error) {
    console.log(error);
  } else {
    console.log('비동기적 파일 쓰기 완료!');
  }
});

//  동기적 파일 쓰기
// 동기적 파일 쓰기가 먼저 실행됨
try {
  fs.writeFileSync('text2.txt', data, 'utf8');
  console.log('동기적 파일 쓰기 완료');
} catch (error) {
  console.log(error);
}

// 동기적 읽기
var text = fs.readFileSync('text2.txt', 'utf8');
console.log('동기적 읽기 : ' + text);

// 비동기적 읽기
fs.readFile('text1.txt', 'utf8', function(err, data) {
  console.log('비동기적 읽기 : ' + data);
});


