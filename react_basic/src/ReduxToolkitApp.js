import './App.css';
import { useEffect, useState } from 'react';
import ReduxCounter from './components/ReduxCounter';
import { configureStore, createSlice } from '@reduxjs/toolkit';
import { Provider } from 'react-redux';

// 리덕스 툴킷 설치
// 프로젝트 생성 시 : npx create-react-app <my-app> --template redux
// 생성된 프로젝트에 도입 : npm install @reduxjs/toolkit

// 리덕스는 하나의 데이터베이스에 모든 데이터를 집어넣은것에 비유한다면
// 리덕스 툴킷은 기능별로 작은 store로 쪼개어 분리 (마치 모듈화처럼)


// slice(작은 store) 생성 : 기능별로 slice 생성 가능
const counterSlice = createSlice({
  name: 'counterSlice',  //store 의 이름
  initialState: { value: 0 },  //store 의 초기값 설정
  reducers: {
    // 값 증가 reducer
    up: (state, action) => {
      console.log("up Called....");
      console.dir(`스텝: ${action.step}` );
      // 상태값 업데이트
      state.value = state.value + action.step;
    },
    down: (state , action) => {
      // 값 감소
      state.value = state.value - action.step;
    }
}
});

// slice로 나눈 작은 store 들을 다시 합치기
const store = configureStore({
  // 
  reducer: {
    // 여러개의 reducer를 하나로 합친 reducer
    // counterSlice.reducer를 ConfigStore의 reducer로 전달
    counter: counterSlice.reducer
  }
});


// 렌더링 함수 : 자바클래스의 main
function ReduxToolkitApp() {



  return (
    //store를 Provider의 스토어로 전달
    <Provider store={store}>
      <div>
        <ReduxCounter />
      </div>
    </Provider>
         

  );
}

export default ReduxToolkitApp;
