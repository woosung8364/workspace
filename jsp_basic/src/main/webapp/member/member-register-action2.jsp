<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");

%>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="*" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<jsp:getProperty property="id" name="member" /><br>
<jsp:getProperty property="name" name="member" /><br>
<jsp:getProperty property="passwd" name="member" /><br>
<jsp:getProperty property="mail" name="member" /><br>
</body>
</html>


