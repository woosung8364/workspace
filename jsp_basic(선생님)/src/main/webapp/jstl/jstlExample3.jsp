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
<c:if test = "${score >= 60}">
합격입니다
</c:if>

<c:choose>
<c:when test="${score >= 90}">수</c:when>
<c:when test="${score >= 80}">우</c:when>
<c:when test="${score >= 70}">미</c:when>
<c:when test="${score >= 60}">양</c:when>
<c:otherwise>불합격</c:otherwise>
</c:choose>

</body>
</html>