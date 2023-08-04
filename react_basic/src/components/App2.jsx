import React, { useState,useReducer} from "react";

export default App2;

function App2(){
  const number = null;
  const [count , countDispatch] = useReducer(countReducer,0);


  function DOWN(){
    countDispatch({type : 'DOWN' , number : count});
  }

  function UP(){
    countDispatch({type : 'UP' , number : count});
 }

  function RESET(){
    countDispatch({type : 'RESET' , number : count});
  }



// 장부 , 주문내역
function countReducer(oldCount , action){
  if (action.type === 'UP'){
    return oldCount + action.number;
  } else if (action.type === 'DOWN'){
    return oldCount - action.number;
  } else if (action.type === 'RESET'){
    return 0;
  } 
}

function changeNumber(event){

}


return(
  <div>
    <input type='button' value='-' onClick={DOWN}></input>
    <input type='button' value='0' onClick={RESET}></input>
    <input type='button' value='+' onClick={UP}></input>
    <input type='text' value={number} onChange={changeNumber}></input>
    <span>{count}</span>
  </div>
)
}

