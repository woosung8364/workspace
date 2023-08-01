<%@ page contentType="text/html; charset=utf-8" %>

<%
Cookie[] cookies = request.getCookies();
String counter = null;

if(cookies != null){
	for (Cookie cookie : cookies){
		if(cookie.getName().equalsIgnoreCase("couter")){
			counter = cookie.getValue();
		}		
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>당신은 <%=counter %>번째 방문하셨군요..</h2>
</body>
</html>

