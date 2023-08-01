<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%

Cookie[] cookies = request.getCookies();
String name = null;
if(cookies != null){
	for (Cookie cookie : cookies){
		if(cookie.getName().equalsIgnoreCase("name")){
			//쿠키의 값 읽어오기
			name = cookie.getValue();
		}
	}
	
}

name = URLDecoder.decode(name , "utf-8");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>당신은 <%=name +"님" %> 방문하셨군요..</h2>
</body>
</html>