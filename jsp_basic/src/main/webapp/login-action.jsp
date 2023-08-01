<%@ page contentType="text/html; charset=utf-8"%>


<%
request.setCharacterEncoding("utf-8");
String uid = request.getParameter("uid");
String upw = request.getParameter("upw");

//편의상 DB 처리 생략 ( 무조건 회원이라 가정)
String name = "송우성";
session.setAttribute("loginId", uid );
session.setAttribute("loginName", name);

response.sendRedirect(application.getContextPath()+"/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%= uid %>
<%= upw %>
</body>
</html>