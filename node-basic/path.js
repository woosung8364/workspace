
const path = require('path');

// 운영체제 경로 구분자
console.log(path.sep);

// 주요 메서드 
console.log(__filename); // C:\ezen-fullstack\workspace\node-basic\path.js
console.log(__dirname);  // C:\ezen-fullstack\workspace\node-basic 
console.log(path.dirname(__filename));  // C:\ezen-fullstack\workspace\node-basic
console.log(path.basename(__filename)); // path.js

let myPath = path.dirname("/foo/bar/baz/image.png");
console.log(myPath);  // /foo/bar/baz
myPath = path.basename("/foo/bar/baz/image.png");
console.log(myPath); // image.png
myPath = path.basename("/foo/bar/baz/image.png", ".png");
console.log(myPath); // image
myPath = path.extname("/foo/bar/baz/image.png");
console.log(myPath); // .png

myPath = path.parse("/home/user/dir/file.txt");
console.log(myPath); // {  root: '/',  dir: '/home/user/dir',  base: 'file.txt',  ext: '.txt',  name: 'file' }

myPath = path.format(myPath);
console.log(myPath); // /home/user/dir/file.txt

myPath = path.normalize("/this/is//////a//my/.././path/normalize");
console.log(myPath); // \this\is\a\path\normalize

myPath = path.join("/this", "is", "a", "////path//", "join");
console.log(myPath); // \this\is\a\path\join

// cwd를 사용하여 절대경로 반환
myPath = path.resolve("/this", "is/a", "../.", "path", "resolve");
console.log(myPath); // C:\this\is\path\resolve

myPath = path.resolve("myroot", "static/png/", "../gif/image.gif");
console.log(myPath); // C:\ezen-fullstack\workspace\node-basic\myroot\static\gif\image.gif

