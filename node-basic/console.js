
let result = 0;
console.time("수행시간");

for (let i = 1; i <= 100; i++) {
  result += i;
}

console.timeEnd("수행시간");
console.log("1부터 100까지의 합 : %d", result);

function doTask() {
  console.trace();
}
doTask();

