
const fs = require('fs');
const fs_promise = fs.promises;

// 기타 fs 파일 주요 메서드
// 파일, 디렉터리 존재 및 접근 여부 체크
const path = './text1.txt';
fs.access(path, fs.constants.F_OK, (error) => {
  if (error) { throw error; }
  console.log('파일이 존재합니다.');
});
fs.access(path, fs.constants.F_OK | fs.constants.R_OK | fs.constants.W_OK, (error) => {
  if (error) { throw error; }
  console.log('파일이 존재하고, 읽기 및 쓰기 가능합니다.');
});

// 디렉터리, 파일 생성 
const dirPath = './folder';
const newFile = 'test.js';


// fs.constants.F_OK - 디렉터리가 존재하는지 검증
// fs.constants.R_OK - 읽기 권한이 있는지 체크 
// fs.constants.W_OK - 쓰기 권한이 있는지 체크
// 
fs_promise.access(dirPath, fs.constants.F_OK | fs.constants.R_OK | fs.constants.W_OK)
  .then(() => {
    // 디렉터리가 이미 존재하고 읽기쓰기 권한이 있을시~
    console.log("디렉터리가 이미 존재합니다.");
  })
  .catch(error => {
    // 디렉터리 존재하지 않을 경우
    if (error.code === 'ENOENT') {
      console.log('디렉터리 존재하지 않아 새로 생성');
      return fs_promise.mkdir('./folder');
    }
    // 디렉터리 존재하고 권한이 없을 경우
    return Promise.reject(error);
  })
  .then(() => {
    console.log('디렉터리 생성하였습니다.');
    return fs_promise.open(`${dirPath}/${newFile}`, 'w'); // 쓰기 가능 빈 파일 생성
  })
  .then(() => {
    console.log('빈 파일 생성 완료!');
  })
  .catch((error) => {
    console.error(error);
  });

  