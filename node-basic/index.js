// let object = require('./vars');
// console.log(object)
// console.log(object.odd);
// console.log(object.even);

// 구조분해 할당 - 객체를 바로 받겠다
// const {odd , even , checkOddOrEvenEvendEven} = require('./vars');
// console.log({odd , even});
// console.log(odd);
// console.log(even);

console.time('수행시간');

const {odd , even , checkOddOrEven} = require('./vars');
console.log(odd);
console.log(even);
console.log(checkOddOrEven(10));


console.log(this);
console.log(this === module.exports);

function doTask(){
    console.log(this);
}

let index = 1;

doTask();

console.timeEnd('수행시간');

const interval = setInterval(()=>{
    console.log('조장님 바보');
}, 1000);