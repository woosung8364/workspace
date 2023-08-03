import { useState } from "react";

function Counter() {
  // console.log("Count() 호출됨....");
  // let count = 1;
  // let array  =  useState(1);
  // let count = array[0];
  // let setCount = array[1];
  
  // console.dir(array);
  // 훅(Hook) 함수
  let [count, setCount]  =  useState(1);
  const increamentCount = () => {
    setCount(count + 1);
  }
  return (
    <div>
      <p>{count}</p>
      <button onClick={increamentCount}>카운트 증가</button>
    </div>

  );
}

export default Counter;