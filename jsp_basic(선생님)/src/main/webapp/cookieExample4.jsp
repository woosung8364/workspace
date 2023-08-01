<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
Cookie[] cookies = request.getCookies();
String name = null;

if(cookies != null){
	for (Cookie cookie : cookies){
		if(cookie.getName().equalsIgnoreCase("name")){
			name = cookie.getValue();
		}		
	}
}
name = URLDecoder.decode(name, "utf-8");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2><%=name %></h2>
</body>
</html>

