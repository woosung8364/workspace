<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- JSTL - 속성 벨류 설정해보기 --%>
<c:set var="score" value="88" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1">
</c:forEach>
${i}

<h2>동적 구구단</h2>
<table border="1">
<c:forEach var="i" begin="2" end="9">
<tr>
	<c:forEach var="j" begin="1" end="9">
	<td>${ i }  * ${ j } = ${i * j }<td>
	</c:forEach>
</tr>
</c:forEach>
</table>
</body>
</html>