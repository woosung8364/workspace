import React from "react";

// 재사용을 위한 사용자 정의 컴포넌트
function Header(props){
  console.dir(props);
  return (
  <header>
    <h1 className='App'><a href="/" onClick={(event) =>{
      event.preventDefault();
      props.onChangeMode();
    }}>{props.title}</a></h1>
    <h2>{1 == 1 ? (<div>정답입니다</div>) : (<div>오답입니다</div>)}</h2>
  </header>
  )
}


export default Header;