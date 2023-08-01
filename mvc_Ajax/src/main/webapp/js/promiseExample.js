

// 성공할때와 실패했을때를 구분하기위한 매게변수 지정
function doAsyncTask(resolve , reject){
  setTimeout(function(){} , 3000);

  //let serverMessage = "서버로부터 수신한 데이터";
  let serverMessage = '졸려~~';

  if (serverMessage) {
    // promise 에게 데이터 전달
    resolve(serverMessage);
  } else { 
    reject("데이터 수신 실패");
  }
}


//doAsyncTask();

// promise 객체한태 doAsyncTask 함수를 전달
// doAsyncTask를 다이렉트로 호출하는게 아니라 promise 에서 실행
// let promise = new Promise(doAsyncTask);

// 정상적으로 호출 성공시
// resolve 대입변수가 message로 들어옴
// promise.then(function(message){

//   alert(message);
// }).catch(function(error){
// 	alert(error);
// });


// 위 코드를 한줄로 축약
// 정상데이터는 then 으로 비정상데이터는 catch 로 
new Promise(doAsyncTask)
.then(message=> alert(message))
.catch(error=> alert(error));


