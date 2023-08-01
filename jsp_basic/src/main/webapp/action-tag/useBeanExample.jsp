<%@page import="ezen.member.Member"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
//Member member= new Member("bangry" , "송우성" , "1234" , "seo8362@naver.com" , "20230706");
//request.setAttribute("member", member);
%>
<%

%>

<jsp:useBean id="member" class="ezen.member.Member" scope="request"/> 
<jsp:setProperty property="id"  name="member" value="bangry"/>
<jsp:setProperty property="name"  name="member" value="송우성"/>
<jsp:setProperty property="email"  name="member" value="seo8362@naver.com"/>
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


이름 : <%= member.getName() %> <br>
이름 : <jsp:getProperty property="name" name="member" /><br>
</body>
</html>