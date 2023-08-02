import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import { useState } from 'react';

function App() {
  // let mode = 'WELCOME' ;
  let [mode, setMode] = useState('WELCOME');
  let [id, setId] = useState(null);

  const topics = [
    { id: 1, title: 'html', body: 'html is...' },
    { id: 2, title: 'css', body: 'css is...' },
    { id: 3, title: 'js', body: 'js is...' }
  ];
  
  topics.forEach((topic)=>{
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
  if (mode === 'WELCOME') {
    content =
      <Article title='환영합니다.. WEB' body='안녕 Web'>

      </Article>
  } else if (mode === 'READ') {
    let title, body = null;
    console.log(id);
    console.log(topics);
    for (let i = 0; i < topics.length; i++) {
       if(topics[i].id === id){
        title = topics[i].title;
        body = topics[i].body;
       }
    }
    content = <Article title={title} body={body}></Article>;

  }




 


  return (
    <div>
      {/* 오 이게뭐야 */}
      <Header title="React" onChangeMode={changeMode} />
      <Nav topics={topics} onChangeMode={changeMode} />
      {content}
      <Article title="Welcome" body="Hello, Web" />
    </div>

  )


}

export default App;
