const express = require('express');
const path = require('path');
const fs = require('fs');
const template = require('./lib/template');
const app = express();
const qs = require('querystring');
const bodyParser = require('body-parser');

const port = 3002;

// 요청 매핑 (노드에서는 라우팅이라 한다)
app.get('/', function (req, res) {
    // public 폴더의 파일 목록을 html로 렌더링
    fs.readdir('./public', (error, fileList) => {
        const title = '홈페이지';
        const list = template.list(fileList);
        const control = `<a href="/create">create</a>`;
        const description = 'Hello, Node.js';
        const contents = `<h2>${title}</h2>${description}`;
        const html = template.toHtml(title, list, control, contents);
        res.send(html);
    });
});

// 상세보기 (Path Variable)
app.get('/read/:id', function (req, res) {
    // 쿼리스트링 수신
    //let { userId, userPw } = req.query;
    fs.readdir('./public', (error, fileList) => {
        fs.readFile(`./public/${req.params.id}.html`, 'utf-8', (error, fileContents) => {
            const title = '글 상세';
            const list = template.list(fileList);
            const control = `<a href="/create">create</a>
                             <a href="/update?id=${title}">update</a>
                             <form action="delete_process" method="post">
                             <input type="hidden" name="id" value="${title}">
                             <input type="submit" value="delete">
                            </form>`;
            const description = fileContents;
            const contents = `<h2>${title}</h2>${description}`;

            const html = template.toHtml(title, list, control, contents);
            res.send(html);
        });
    });
});

// 글 등록 화면
app.get('/create', function (req, res) {
    fs.readdir('./public', (error, fileList) => {
        const title = '글 등록';
        const list = template.list(fileList);
        const control = `<form action="/create" method="post">
                         <p><input type="text" name="title" placeholder="title"></p>
                         <p><textarea name="description" placeholder="description"></textarea></p>
                         <p><input type="submit" value="등록"></p>
                         </form>`;
        const contents = '';
        const html = template.toHtml(title, list, control, contents);
        res.send(html);
    });
});

// 글 등록 처리
/*
app.post('/create', function (req, res) {
    let body = '';
    // POST 방식으로 전달되는 데이터는 이벤트 처리 방식으로 전달받는다.
    req.on('data', data => {
        body = body + data;
    });

    req.on('end', () => {
        const params = qs.parse(body);
        const title = params.title;
        const description = params.description;
        fs.writeFile(`./public/${title}.html`, description, 'utf-8', error => {
            // 리다이렉트
            res.writeHead(302, { Location: `/read/${title}` });
            res.end();
        });
    });
});
*/

// 글 등록 처리
// 익스프레스 미들웨어 사용하기
// 미들웨어 : HTTP 요청과 응답 사이에서 단계별 동작을 수행해주는 모듈(함수)이다
// body-parser 미들웨어 설치 : npm install body-parser --save
app.use(bodyParser.urlencoded({extended: false}));

app.post('/create', function (req, res) {
    const params = req.body;
    const title = params.title;
    const description = params.description;
    fs.writeFile(`./public/${title}.html`, description, 'utf-8', error => {
        // 리다이렉트
        res.writeHead(302, { Location: `/read/${title}` });
        res.end();
    });
});

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})
