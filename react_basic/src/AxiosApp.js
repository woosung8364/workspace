import axios from 'axios';
import './App.css';
import { useEffect, useState } from 'react';


function AxiosApp() {

  const [posts , setPosts] = useState([]);

  const url= 'https://jsonplaceholder.typicode.com/posts';

  // onload 함수랑 비슷하다
  // 컴포넌트가 렌더링 될 때마다 실행되고, 렌더링 이후에도 계속해서 호출
  // 특정 상태가 업데이트 될 때 추가적인 동작을 수행하고자 할 때 사용
  useEffect(() => {
    // POST 요청 전송
    axios({
      method: 'get',
      // jsonplaceholder 사이트의 json 형식 정보를 get 방식으로 불러들여옴
      url: 'https://jsonplaceholder.typicode.com/posts'
    }).then(function (response) {
      // 데이터가 제대로 들어오는지 디버깅
      // console.log(response.data);
      setPosts(response.data);
    });
  }, []);



  return (
    <div>
      <ul>
        {/* forEach를 쓰면 반환값이 없으므로 빈화면이 출력 */}
        {/* 고로 반환값이 있는 map 함수를 사용했음 , map 함수 사용시 정상적으로 변경된 배열이 출력 */}
        {posts.map((post)=>{
         return  <li key={post.id}>{post.userId} : <a href={url}>{post.title}</a></li> 
        })}
      </ul>
    </div>


  );
}

export default AxiosApp;
