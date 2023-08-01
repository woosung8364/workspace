// 이벤트 소스에 이벤트 리스너 등록
const button = document.querySelector('button');
button.addEventListener('click', event => {
  memberRegister();
});

function memberRegister(){
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
  const url = '/member-register.jsp';
  const options = {
    method : 'post' , 
    headers : {
      "Content-Type" : "application/x-www-form-urlencoded"
    } ,
    // json 형식의 객체인 member 를 문자열로 변환
    body : JSON.stringify(member)
    
  }
  fetch(url , options)
  .then(response => response.json())
  .then(result => {
	  showResult(result);
	 // console.dir(result);
  });
  // .catch(error => alert(error));
  
}

function showResult(result){
	// alert(message);
 const view = document.querySelector("#result");
  if (view) {
	  if(result.result){
		  view.innerHTML = result.message;
	  } else{
		 view.innerHTML = "회원 등록이 실패하였습니다..";
	  }
    
  }
 
}
