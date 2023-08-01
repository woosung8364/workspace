<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String[] interests = request.getParameterValues("interest");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
당신의 이름은 : <%=name %><br>
취미<br>
<%
if(interests != null){
	for(String interest : interests){
%>

	<%= interest %>	

<%	
	}	
}
%>



</body>
</html>


