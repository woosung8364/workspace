<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>정상적으로 파일 업로드 처리되었습니다.</h2>
업로더 : ${uploader}<br>
업로드파일이름 : ${uploadfiles}

<ul>
	<c:forEach items="${uploadfiles}" var="file">
	<li>${file.uploadFileName} / ${file.storeFileName} </li>
	</c:forEach>
	
</ul>
</body>
</html>