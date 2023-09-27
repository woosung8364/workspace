
// http 라는 이름의 모듈 가져오기
const http = require('http');
// fs 라는 이름의 모듈 가져오기
const fs = require('fs').promises;

// 포트번호 설정
const port = '3000';

// 서버 생성 (응답 , 요청)
const server = http.createServer(async (req , res) => {
    // GetMapping 과 같은 역할 
    // url 별로 동작되는 코드 설정
    if (req.url === '/') {
        res.writeHead(200, { 'Content-type': 'text/html; charset=utf-8' });
        res.write('<h2>핑크타릭 핑크 바루스 핑크 한조</h2>');
        res.write('<h2>배그 운전하고 싶다</h2>');
        res.end();

        // url이 localhost:3000/hello 인경우
    } else if(req.url === '/hello'){
        // viewName 지정
        const html = await fs.readFile('./hello.html');
        res.writeHead(200, { 'Content-type': 'text/html; charset=utf-8' });
        // 끝내면서 hello.html 파일안의 내용을 출력
        res.end(html);
    }
   
})


// 서버 리스닝
server.listen(port);
server.on('listening', () => {
    console.log(`${port}번 포트에서 서버 리스닝중 ...`);
});
server.on('error', () => {
    console.log(`${port}에서 서버를 구동하다 에러가 발생하였습니다`);
})