<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	업로드 한 넘 : ${uploader}
	<br> 업로드 파일명 : 
	<c:forEach items="${uploadFiles }" var="fileName">
${fileName}
</c:forEach>
</body>
</html>