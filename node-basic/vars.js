// 모듈 사용하기
const odd = '홀수';
const even = '짝수'; 

// 변수 하나만 내보낼때
// module.exports.even = even;
// module.exports.odd = odd;
// module.exports= [odd , even];
// module.exports = {
//     odd,
//     even
// };


function checkOddOrEven (num){
    if(num % 2){
        return odd;
    } else{
        return even;
    }
}

// this.exports= {
//     odd,
//     even,
//     checkOddOrEven
// };

module.exports= {
    odd,
    even,
    checkOddOrEven
};

// module.exports = checkOddOrEven;
