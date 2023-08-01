<%@page import="ezen.member.Member"%>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:useBean id="member" class="ezen.member.Member" scope="request"/>
<jsp:setProperty property="name" name="member" value="김기정"/>
<jsp:setProperty property="id" name="member" value="bangry"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

아이디 : <%= ((Member)request.getAttribute("member")).getId() %><br>
이름 : <%= ((Member)request.getAttribute("member")).getName() %><br>
이름 : <jsp:getProperty property="name" name="member"/><br>

<%-- 스코프 객체에 저장된 빈의 속성 접근 --%>
이름 : ${member.name}<br>

<%-- EL에서 사용 가능한 연산자 --%>
${ 4 / '5' } <br>
${ (10>5) || (0<10) } <br>

<%-- EL 내장 객체 11개 --%>
이름 : ${requestScope.member.name}

${ empty member.email}





</body>
</html>






