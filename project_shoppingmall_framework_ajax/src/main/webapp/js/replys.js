/*
* 게시판에 관련된 자바스크립트 파일
*/


// 모든 replyBtn을 id로 가진 태그를 검색해서 replyBtns 에 담음 
const replyBtns = document.querySelectorAll("#replyBtn");
// 모든 repolyBtn에 클릭이벤트 부여 - 클릭시마다 getReply 함수가 호출되서 실행됨
replyBtns.forEach(btn => {
	btn.addEventListener('click', getReply);
});



async function getReply(event) {
//	event가 발생한곳의 벨류를 memoid에 저장
	const memoId = event.target.value;
//	memoID 매게변수를 대입한 requestReplys 함수를 replys 변수에 대입
    let replys = await requestReplys(memoId);
//    showReply 함수를 실행 
    showReply(memoId, replys);
}

//event가 발생한곳의 경로를 읽어와서 
function requestReplys(memoId) {
//	memoId를 활용하여 댓글의 데이터를 요청할 url을 생성
    const url = `/mall/article/reply?id=${memoId}`;
//    fetch(url) : http get 요청을 보내는 역할 , promise 를 반환
//    .then () : promise 객체가 처리된 이후에  수행할 콜백함수를 등록
    return fetch(url).then(response => response.json());
}



function  showReply(memoId, replys) {
//	모든 replyView id를 가진 태그를 views 변수에 담음
	const views = document.querySelectorAll("#replyView");
	
	
	views.forEach(p => {
		if(memoId === p.dataset.id){
			// 댓글을 HTML 태그에 맞게 출력
			let ul = `<ul>`;
			replys.forEach(reply => {
				ul += `<li>${reply.content}(${reply.regdate}) -  ${reply.id}</li>`;	
			});
			ul += `</ul>`;
			p.innerHTML = ul;
		}
	});
}





