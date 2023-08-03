// 재사용을 위한 사용자 정의 컴포넌트
function Header(props) {
  console.dir(props);
 
  return (
    <header>
      <h1><a href="/" onClick={ event => {
        event.preventDefault();
        props.onChangeMode();
      }}>{props.title}</a></h1>
    </header>
  );
}

export default Header;