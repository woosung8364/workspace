// 재사용을 위한 사용자 정의 컴포넌트
function Nav(props) {
  const list = [];
  const topics = props.topics;
  // console.dir(topics);
  topics.forEach(topic => {
     list.push(<li key={topic.id}><a id={topic.id} href={'/read/'+topic.id} onClick={event =>{
      event.preventDefault();
      props.onChangeMode(Number(event.target.id));
     }
     }>{topic.title}</a></li>);   
  });

  return (
    <nav>
        <ol>
          {list}
          {/* <li><a href="/read/1">HTML</a></li> */}
        </ol>
      </nav>
  );
}

export default Nav;