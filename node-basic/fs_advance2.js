
const fs = require('fs');
const fs_promise = fs.promises;

// 파일 목록 가져오기
fs.readdir('.', function(error, fileList){ 
	fileList.forEach(file => {
    console.log(file);
  }); 
});

// 파일 이름 수정
// fs.rename(oldPath, newPath, callback)
fs.rename('./test.txt','./test1.txt', (error) => {
  if(error){
    console.log('파일 이름 수정 에러 발생');
  } else{
    console.log("파일 이름 수정 완료");
  }
});

// 파일 삭제
// fs.unlink(Path, callback)
fs.unlink('./test1.txt', (error) => {
  console.log('파일 삭제 완료');
})

// 디렉터리 삭제
fs_promise.rmdir('./mydir')
  .then(() => {
    console.log("디렉터리 삭제 완료");
  })
  .catch(error => {
    console.error(error);
  });

  // 파일 복사
  fs_promise.copyFile('./text1.txt', 'copied.txt')
  .then(() => {
    console.log("복사 완료");
  })
  .catch(error => {
    console.error(error);
  });


  