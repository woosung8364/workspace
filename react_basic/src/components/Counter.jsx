import React, { useState } from "react";

// 재사용을 위한 사용자 정의 컴포넌트
function Counter(props) {
  // let count = 1;
  // let array = useState(1);
  // let count = array[0];
  // let setCount = array[1];
  // console.dir(array);

  // 상태값을 저장하기위해 UseState 함수 선언
  let [count , setCount] = useState(1)
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