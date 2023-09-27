// 모듈들 불러오기
const http = require('http');
const fs = require('fs').promises;
const path = require('path');

// 테스트 객체
const members = {
    result : "OK",
    list : [{name: "월요일"}, {name: "화요일"}, {name: "수요일"}]
};

// 포트설정
const port = '3000';

// 서버 생성
const server = http.createServer(async (request, response) => {
    try {
        // url 요청이 get일경우
        if (request.method === 'GET') {
            // url 요청이 / 즉 : localhost:3000 일경우
            if (request.url === '/') {
                // (디렉토리 이름) / index.html 의 html내용을 해석해서 data에 담음
                const data = await fs.readFile(path.join(__dirname, 'index.html'));
                response.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                return response.end(data);
            // url 요청이 /about 즉 : localhost:3000/about 일경우
            } else if (request.url === '/about') {
                const data = await fs.readFile(path.join(__dirname, 'about.html'));
                response.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                return response.end(data);
            } else if (request.url === '/members') {
                response.writeHead(200, { 'Content-Type': 'application/json; charset=utf-8' });
                // members 객체를 JSON 형식의 문자열로 변환해서 리턴함
                return response.end(JSON.stringify(members));
            }
            try {
                const data = await fs.readFile(path.join(__dirname, request.url));
                return response.end(data);
            } catch (error) {
                response.writeHead(404);
                return response.end('NOT FOUND');
            }
        } else if (request.method === 'POST') {
            if (request.url === '/member') {
                console.log('post 요청');
                // 콜백함수가 실행되고 나면 body에는 데이터가 포함된 json 이 담긴다
                let body = '';
                // 데이터가 많으면 이 콜백함수가 여러번 호출
                request.on('data', (data) => {
                    body += data;
                });
              
                return request.on('end', () => {
                    console.log('요청메시지 : ', body);
                    const member = JSON.parse(body);
                    members.list.push(member);
                    response.writeHead(201, { 'Content-Type': 'text/plain; charset=utf-8' });
                    response.end('등록 성공');
                });
            }
        }
        response.writeHead(404);
        return response.end('NOT FOUND');
    } catch (error) {
        console.error(error);
        response.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
        response.end(error.message);
    }
});

server.listen(port);
server.on('listening', () => {
    console.log(`${port}포트에서 서버 실행 및 대기중입니다.`);
});
server.on('error', error => {
    console.error(error);
});

