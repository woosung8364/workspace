
// process 객체의 주요 속성
// console.dir(global.process.version);
// console.dir(process.version);
// console.dir(process.platform);
// console.dir(process.pid);
           
// console.dir(process.execPath);
// console.dir(process.env);
// console.log('OS 환경 변수값 : ' + process.env['OS']);
// console.log('HOME 환경 변수값 : ' + process.env['HOME']);

// console.log(process.argv.length);
// console.log(process.argv[0]);
// console.log(process.argv[1]);


// 명령행 인자 받기
if(process.argv.length > 2){
  process.argv.forEach( (value, index) =>{
    console.log(index, value);
  } );
}

// process 객체의 주요 메서드
console.log(process.cwd());
console.log(process.memoryUsage());
console.log(process.uptime());
for (let i = 0; i < 100; i++) {
  if(i === 50){
    process.exit();
  }  
}


