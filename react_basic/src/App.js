import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import { useState } from 'react';
import Create from './components/Create';
import Update from './components/Update';

function App() {
  // let mode = 'WELCOME' ;
  let [mode, setMode] = useState('WELCOME');
  let [id, setId] = useState(null);

  const [topics , setTopics] = useState([
    { id: 1, title: 'html', body: 'html is...' },
    { id: 2, title: 'css', body: 'css is...' },
    { id: 3, title: 'js', body: 'js is...' }
  ]);
  
  const [nextId , setNextId] = useState(4);

  topics.forEach((topic) => {
    console.log(typeof topic.id);
  });




  // 모드 변경
  const changeMode = (id) => {

    if (id) {
      setId(id);
      setMode('READ');
    } else {

      setMode('WELCOME');
    }

  }



  // 모드의 값에 따라 상세정보 (Article) 다르게 보여주기

  let content = null;
  let contextControl = null;

  // WELCOME
  if (mode === 'WELCOME') {
    content =
      <Article title='환영합니다.. WEB' body='안녕 Web'>

      </Article>



// READ
  } else if (mode === 'READ') {

    // HTML ,CSS , JS 클릭하면 클릭한것에 맞추어 동적으로
    // title과 body의 내용이 바뀌는 부분
    let title, body = null;
    for (let i = 0; i < topics.length; i++) {
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;


    // HTML ,CSS , JS 클릭하면 나오는 update , delete 버튼
    contextControl = <>
    <li><a href={'/update/'+id} onClick={(event)=>{
      event.preventDefault();
      // update a태그 클릭시 mode가 UPDATE 로 바뀜
      setMode('UPDATE');
    }}>글을 수정해볼까요????????????</a></li>

    {/* ---------DELETE--------- */} 
    {/* 방법1 */}
    <li><input type="button" value="글을 삭제할까요????????" onClick={()=>{
      // 빈배열 생성
      const newTopic = [];
      for (let i = 0; i < topics.length; i++) {
        // ID가 불일치 하는 Topics[i]가  없으니 빈배열에 빈배열 추가
        if (topics[i].id !== id) {
          newTopic.push(topics[i]);
        }
        
      }




      // 결과적으로 빈배열을 설정함으로서 삭제됨
      setTopics(newTopic);
    }}></input></li>
    </>


// CREATE
  } else if (mode === 'CREATE'){
    // Create 함수에 props 속성으로 전달할 atitle , bbody
    content = <Create onCreate={(atitle , bbody)=>{
      // topics에 3개의 배열이 설정되어있음 고로
      // nextID에는 useState 를 사용해 default 값을 4로 지정
      const newTopic = {id:nextId , title:atitle , body:bbody}
      // topics 배열 복사
      const newTopics = [...topics];
      // newTopic 에 설정된 정보값들을 배열로 담음
      newTopics.push(newTopic);
      // newTopic의 정보가 담긴 newTopics 를 Topics 배열에 추가
      setTopics(newTopics);    
      // 작업이 다 끝났다면 read 모드로 전환
      setMode('READ');
      // nextId에 설정된 값을 id로 설정함
      // topics에 배열이 3개있으니 nextId는 4가 기본값이도록 설정해둠
      setId(nextId); 
      // nextId를 써먹었으니 다음 생성을 위해 nextId 값도 1 늘려둔다
      setNextId(nextId+1);                                                                           
    }}></Create>;

    // Update
    // 모드가 update 모드일떄
  } else if (mode === 'UPDATE'){
    let title, body = null;
    for (let i = 0; i < topics.length; i++) {
      // topics 배열중 id값이 일치하는 배열의 정보(title,body)만 리턴
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }

    // update 모드로 진입해도 기존 컨텐츠는 그대로 보여야함
    content = <Update id ={id} title={title}  body = {body} onUpdate={(title,body)=>{
      
      // 전개연산자 : [...topics] 배열을 펼쳐서 새로운 배열또는 객체를 만드는데 사용
      // state 객체에 저장된 객체의 경우 , 데이터의 변경을 직접 할 수 없기 때문에
      // 저장된 데이터 타입이 객체인경우 배열의 복제본을 만들어서 설정해야한다
      const newTopics = [...topics];
     
      // Update.jsx 로부터 state에 저장된 title과 body 값을 넘겨받아
      // 객체 배열을 생성함 title과 body값은 사용자가 input 에 입력한 값임
      const updatedTopic = { title:title , body : body}

      // 복제된 배열으로부터 루프돌려서 복제된 배열과 updatedTopic 변수에 저장된 배열의 id값을 비교

      for (let i = 0; i < newTopics.length; i++) {
        if (newTopics[i].id === id) {
          // 결과적으로 newTopics는 id값이 일치하는 한개의 배열만 남음
          newTopics[i] = updatedTopic;
          break;
        }
      }
      // 위의 필터링을 통해 걸러낸 배열인 newTopics 를 topics 배열에 저장함
      setTopics(newTopics);
      // 작업이 다 끝났으면 Mode를 read로 변경
      setMode('READ');
    }}></Update>
  }







  return (
    <div>
      {/* 속성 , 값이 컴포넌트의 매게변수로 전달됨 :props */}
      {/* ex)onChangeMode = {changeMode} */}
      <Header title="React" onChangeMode={changeMode} />
      <Nav topics={topics} onChangeMode={changeMode} />
      {content}
      <Article title="Welcome" body="Hello, Web" />
      <ul>

        {/* create */}
      <li><a href="/Create" onClick={(event) => {
        event.preventDefault();
        setMode('CREATE');
      }}>글을 새로 만들어볼까요?????????????</a></li>
      {/* update , delete bt */}
      {contextControl}
      </ul>
    </div>

  )


}

export default App;
