
memberList();


function memberList() {
  // 편의상 유효성 검증 생략
  const name = '송우성';
  const id = 'song8364';
  const passwd = '1111';
  const email = 'seo8362@naver.com';

  const member = {
    //  name = `${name}` 이 생략됨
    // 변수와 EL문에 선언되는 이름이 똑같을시 아래와같이 생략가능하다
    name,
    id,
    passwd,
    email

  };


  // const url = `/hello-view.jsp?name=${name}`;
  const url = '/members.jsp';

  fetch(url)
    .then(response => response.json())
    // result -> javascript array
    .then(array => {
      showList(array);
    });
  // .catch(error => alert(error));

}

function showList(array) {
  // alert(message);
  // const view = document.querySelector("#result");
  if (array) {
    array.forEach(member => {
      console.log(member);
      //  돔 처리는 여러분이 하세요..
    });

  }

}
