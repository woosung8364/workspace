// 재사용을 위한 사용자 정의 컴포넌트
function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}

export default Article;