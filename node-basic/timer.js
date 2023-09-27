
const timeout = setTimeout(() => {
  console.log('timeout 1초후 실행');
}, 1000);

// 종료
// clearTimeout(timeout);

const interval = setInterval(() => {
  console.log('interval 1초후 실행');
}, 1000);

// 종료
// clearInterval(interval);

