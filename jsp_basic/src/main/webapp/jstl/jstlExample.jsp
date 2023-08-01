<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="name" name="member" value="송우성"/>
<jsp:setProperty property="id" name="member" value="song8364"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
이름 : ${"<페이커> 롤드컵 우승 "} <br>
이름 : <c:out value="<b>페이커</b> 롤드컵 우승" escapeXml="true"/> <br>
이름 : <c:out value="<b>페이커</b> 롤드컵 우승" escapeXml="false"/> <br>
아이디 : ${member.id}<br>
아이디 : <c:out value="${member.id }"/> <br>
e메일 : <c:out value="${member.email }" default="이메일이 없습니다"/>
</body>
</html>