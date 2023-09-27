
// 다운로드 받은 express 모듈 가져오기
const express = require('express');
const path = require("path");
const fs = require('fs');

// 서버생성
const server = express();

// 포트 생성
const port = '3001';



// 요청 매핑 (라우터) - 세부컨트롤러 등록
// get ('요청 url 이름' , 매개변수)
server.get("/" , (request, response)=>{
    response.send('<h2">Gimothi</h2>');
});


server.get("/hello" , (request, response)=>{
    response.sendFile(path.resolve("./public/CSS.html"));
});

server.listen(port , ()=> {
    console.log(`사용된 포트 : ${port}`);
})

