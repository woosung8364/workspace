import { useReducer } from "react";

function reducer (oldState , action){
  if (action == up) {
    return oldState + 1;
  }
}

[state , dispatch] = useReducer(reducer , 0);
dispatch('up');