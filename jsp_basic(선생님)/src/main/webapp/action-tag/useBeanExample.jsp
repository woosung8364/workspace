<%@ page import="ezen.member.Member"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
//Member member = new Member("bangry", "1234", "김기정", "bangry@gmail.com", "2023-01-28");

//Class.forName("ezen.member.Member").newInstance();

//request.setAttribute("member", member);
%>

<jsp:useBean id="member" class="ezen.member.Member" scope="request"/>
<jsp:setProperty property="id" name="member" value="bangry"/>
<jsp:setProperty property="name" name="member" value="김기정"/>
<jsp:setProperty property="mail" name="member" value="bangry@gmail.com"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<%
//Member readMember = (Member)request.getAttribute("member");
%>

이름 : <%= member.getName() %><br>
이름 : <jsp:getProperty property="name" name="member"/><br>


</body>
</html>




























