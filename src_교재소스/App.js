import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import { useState } from 'react';
import Create from './components/Create';
import Update from './components/Update';

function App() {
  // let mode = 'WELCOME';
  // mode 상태 관리
  const [mode, setMode] = useState('WELCOME');
  // 글 번호 상태 관리
  const [id, setId] = useState(null);
  const [nextId, setNextId] = useState(4);
  
  // 글 목록 저장 배열
  // const topics = [
  //   {id: 1, title: 'html', body:'html is...'},
  //   {id: 2, title: 'css', body:'css is...'},
  //   {id: 3, title: 'javascript', body:'javascript is...'}
  // ];
  // 글 목록 상태 관리
  // 글 등록에서 글이 등록되면 Nav 컴포넌트의 글 목록이 재렌더링 되어야 하기 때문에
  // 글 목록을 상태로 끌어 올린다.
  const [topics, setTopics] = useState(
    [
      { id: 1, title: 'html', body: 'html is ...' },
      { id: 2, title: 'css', body: 'css is ...' },
      { id: 3, title: 'javascript', body: 'javascript is ...' },
    ]
  );

  // mode의 값에 따라 다른 컴포넌트 렌더링
  let content = null;

  // 글 수정/삭제는 상세보기 페이지일 때만 노출되게 하기 위해 변수 선언
  let contextControl = null;

  if(mode === 'WELCOME'){
    content = <Article title='환영합니다..' body='안녕. Web' />
  }else if(mode === 'READ'){
    // content = <Article title='환영합니다..' body='안녕. Read' />
    let title, body = null;
    topics.forEach(topic => {
      if(id === topic.id){
        title = topic.title;
        body = topic.body;
      }
    })   
    content = <Article title={title} body={body} />

    contextControl = <>
    // 글 상세보기일때만 글 수정 링크 보이기
    contextControl = <li><a href={`/update/{id}`} onClick={event =>{
      event.preventDefault();
      setMode('UPDATE');
    }}>글 수정</a></li>
    
    <li><input type='button' value='글 삭제' onClick={() => {
      const newTopics = [];
      // 삭제하고자 하는 글만 빼고 배열 생성
      topics.forEach(topic => {
        if(topic.id != id){
          newTopics.push(topic);
        }
      });
      setTopics(newTopics);
      setMode('WELCOME');
    }}/></li>
    </>

  } else if (mode === 'CREATE') {
    content = <Create onCreate={(title, body) => {
      console.log(title, body);
      // topics 배열에 글 등록
      const newTopic = { id: nextId, title: title, body: body };
      // state 객체에 저장된 데이터 변경을 직접 할 수 없기 때문에
      // 저장된 데이터타입이 객체인 경우 복제본을 만들어서 설정하여야 한다.
      // topics 배열 복제
      // let srcArray = [1, 2, 3];
      // 스프레드 연산자 활용
      // let destArr = [...srcArray];
      // map() 함수 활용
      // let destArray = srcArray.map(value =>value);
      const newTopics = [...topics];
      // 복제된 newTopics 배열에 글 추가
      newTopics.push(newTopic);
      // state에 글목록 설정
      setTopics(newTopics);
      // 상세페이지로 이동 하기 위해 mode 상태변경
      setMode('READ');
      setId(nextId);
      setNextId(nextId + 1);
    }}></Create>
  } else if(mode === 'UPDATE'){
    let title, body = null;
    topics.forEach((topic, index) => {
      if (topic.id === id) {
        title = topic.title;
        body = topic.body;
      }
    });
    // 글 수정 화면 보이기
    content = <Update title={title} body={body} onUpdate={(title, body) =>{
      console.log(title, body);
      // 수정된 글 내용 (글 번호는 동일)
      const updatedTopic = {id:id, title:title, body:body};
      const newTopics = [...topics];
      newTopics.forEach((topic, index) => {
        if(topic.id === id){
          newTopics[index] = updatedTopic;
        }
      });
      setTopics(newTopics);
    }}></Update>
  }

  // mode 변경
  const  changMode = (id)=>{
    if(id){
      // mode = 'READ';
      setMode('READ');
      setId(id);
    }else{
      // mode = 'WELCOME';
      setMode('WELCOME');
    }
  }
  
  return (
    <div>
      {/* 헤더 정보 */}
      <Header title="Rect" onChangeMode={changMode} />
      {/* 내비게이션 정보 */}
      <Nav topics={topics} onChangeMode={changMode}/>
      {/* 상세 정보 */}
      {content}
      
      {/* 토픽등록 링크 */}
      <ul>
        <li>
          <a href="/creat" onClick={event => {
            event.preventDefault();
            setMode("CREATE");
          }}>글 등록화면</a>
        </li>
        {/* 상세보기는 상세보기 화면에서만 보이는 걸로 */}
        {contextControl}
      </ul>

    </div>
  );
}

export default App;
