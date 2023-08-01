
// 이벤트 소스에 이벤트 리스너 등록
const buton = document.querySelector('button');
buton.addEventListener('click', event => {
  new Promise(getBooks)
    .then(message => JSON.parse(message))
    .then(object =>  showMessage(object))
    .catch(error => alert(error))
    .finally(()=> {
		console.log('정상처리든 아니든 항상 실행');
	})
});

function getBooks(resolve, reject) {

  let request = new XMLHttpRequest();
  request.open('get', '/books.jsp'); // get, post, put, delete, header ....

  request.addEventListener('readystatechange', event => {

    if (request.readyState === 4) {
      if (request.status === 200) {
        resolve(request.responseText);
      } else {
        reject(request.status);
      }


    } else { //미수신
      console.log("데이터 수신중.....");
    }
  });

  // #3. 요청 보내기
  request.send();
  // request.send(`name=${name}`);
}




function onSuccess(message) {
  showMessage(message);
}

function onError(error) {
  alert(error);
}

function showMessage(object) {
  // let bookInfo = JSON.parse(object);
  //console.dir(object);
  // 테이블로 동적 출력

  const tbody = document.querySelector("#books");
  if (tbody) {
    let list = '';
    object.books.forEach((book) => {
      //console.log(book);

      list += `<tr>
    <td>${book.title}</td>
    <td>${book.author}</td>
    <td>${book.publisher}</td>
    <td>${book.price}</td>
    <td>${book.kind}</td>
    </tr>`;
    });

    console.log(list);

    tbody.innerHTML = list;
  }

}