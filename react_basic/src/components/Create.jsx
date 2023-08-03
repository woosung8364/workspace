// 글 입력 폼 컴포넌트
function Create(props) {
  return (
    <article>
      <h2>토픽 입력 화면</h2>
      <form onSubmit={event => {
        event.preventDefault();
        // 사용자 입력 데이터 읽기
        const title = event.target.title.value;
        const body = event.target.body.value;
        props.onCreate(title, body);
      }}>
        <input type='text' name='title' placeholder='글제목'></input>
        <p><textarea name='body' placeholder='글내용'></textarea></p>
        <p><input type='submit' value='글등록'></input></p>
      </form>
    </article>
  );
}

export default Create;