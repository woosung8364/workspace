// 이벤트 소스에 이벤트 리스너 등록

let category =sessionStorage.getItem('category');

function doT(page){
	sessionStorage.setItem('category', event.target.id);
	change(event.target.id,page);
}

function doP(page){
	change(category,page);
}

function doPP(page){
	change1(page);
}

function change(a,page){
	let url = `/mall/article?&category=${a}&page=${page}`;
	if(a==null ||a==""){
		url = `/mall/article?page=${page}`;
	} else if(a=='normal'){
		url = `/mall/comment?category=normal&page=${page}`;
	}
	let form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', url);
	let hiddenField = document.createElement('input');
	hiddenField.setAttribute('type', 'hidden');
	hiddenField.setAttribute('name', 'category');
	hiddenField.setAttribute('value', a);
	form.appendChild(hiddenField);
	
	let hiddenField1 = document.createElement('input');
	hiddenField1.setAttribute('type', 'hidden');
	hiddenField1.setAttribute('name', 'page');
	hiddenField1.setAttribute('value', page);
	form.appendChild(hiddenField1);
	
	document.body.appendChild(form);
	form.submit();
	
	location.href=url;
}


function change1(page){
	let url = `/mall/myarticle?page=${page}`;

	let form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', url);
	let hiddenField1 = document.createElement('input');
	hiddenField1.setAttribute('type', 'hidden');
	hiddenField1.setAttribute('name', 'page');
	hiddenField1.setAttribute('value', page);
	form.appendChild(hiddenField1);
	
	document.body.appendChild(form);
	form.submit();
	
	location.href=url;
}






