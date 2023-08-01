<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="ezen.member.Member" %>
<jsp:useBean id="member" class="ezen.member.Member" scope="request"/>
<jsp:setProperty property="name" name="member" value="송우성"/>
<jsp:setProperty property="id" name="member" value="song8364"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
아이디 :<%= ((Member)request.getAttribute("member")).getId()%><BR>
이름 :<%= ((Member)request.getAttribute("member")).getName() %><BR>
이름 :<jsp:getProperty property="name" name="member"/> <Br>
<%-- 스코프 객체에 저장된 빈의 속성 접근 --%>
이름 :${member.name} <br>

<%-- EL에서 사용 가능한 연산자 --%>
${4 / '5'} <br>
${ (10>5) || (0<10) } <BR>


이름 :${requestScope.member.name} <br>
${empty member.email} <br>
</body>
</html>