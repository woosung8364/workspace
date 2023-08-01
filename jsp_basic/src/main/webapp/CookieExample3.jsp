<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
Cookie nameCookie = new Cookie("name" , URLEncoder.encode("송우성" , "utf-8"));
response.addCookie(nameCookie);
response.sendRedirect("CookieExample4.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
</html>