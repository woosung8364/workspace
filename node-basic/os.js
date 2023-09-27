// 운영체제 관련 정보 및 제어 기능 제공
const os = require('os');
console.log(os.homedir());
console.log(os.cpus());
console.log('개행문자 : ' + os.EOL);