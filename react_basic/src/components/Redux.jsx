import { Provider, useDispatch, useSelector } from "react-redux";
import { createStore } from "redux";
import Left1 from "../Reduc_compponets/Left1";
import Right1 from "../Reduc_compponets/Right1";

export default Redux;


function Redux(){

  // 스토어에 있는 스테이트를 어떻게 바꿀지 결정
  // 현재 스태이트값인 currentState , 어떻게 바꿀지에 대한 요청인
  // action 을 매게변수로 받음
function reducer(currentState , action){
  if (currentState === undefined) {
    // 이에 대한 리턴값이 새로 만들어지는 스테이트의 값이 됨
    return {
      // currentState 이 undefined 인경우는 스테이트가 정의되지 않았다는걸
      // 의미하므로 기본값으로 '1' 을 부여
      number : 1
    };
  }

// 리덕스는 각 스테이트의 변화를 불변하게 유지해줘야함
// 따라서현재 상태의 객체배열을 복사한 새로운 상태의  객체배열 생성 : newState
  const newState = {...currentState};
  if (action.type === 'PLUS'){
    // PLUS 상태일경우 새로운 상태의 객체의 숫자를 1 증가시킴
    newState.number++;
  }
  return newState;
}

// 리덕스 스토어 생성
const store = createStore(reducer);


  // HTML 렌더링하는 부분
return (
  <div id="container">
    <h1>Root</h1>
    <div id="grid">
      <Provider store = {store}>
      <Left1 />
      <Right1 />
      </Provider>
    </div>

  </div>
)
}