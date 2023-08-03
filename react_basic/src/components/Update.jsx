import { useState } from "react";

// 글 수정 폼 컴포넌트
function Update(props) {
  const [title, setTitle] = useState(props.title);
  const [body, setBody] = useState(props.body);
  return (
    <article>
      <h2>글 수정</h2>
      <form onSubmit={event => {
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onUpdate(title, body);
      }}>
        <input type='text' name='title' placeholder='글제목' value={title} onChange={event => {
          // console.log(event.target.value);
          setTitle(event.target.value);
        }}></input>
        <p><textarea name='body' placeholder='글내용' value={body}  onChange={event => {
          setBody(event.target.value);
        }}></textarea></p>
        <p><input type='submit' value='글수정'></input></p>
      </form>
    </article>
  );
}

export default Update;