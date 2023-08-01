//  Open API 사용하기
showList();


function movieList() {
  const url = 'https://www.googleapis.com/books/v1/volumes?q=javascript';
  let promise = fetch(url);
  return promise.then( response => response.json());
}


async function showList() {
  let object = await movieList();
  const totalItems = object.totalItems;
  console.log('총권수 : ',totalItems);
  const list = object.items;
  const view = document.querySelector('#result');
  if (list) {
    list.forEach( book => {
      console.log(book);
      //  돔 처리는 여러분이 하세요..
    });

  }

}
