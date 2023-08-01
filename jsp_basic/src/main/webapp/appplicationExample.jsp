<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
웹 애플리케이션 이름(컨텍스트 패스) : <%=application.getContextPath() %>
<%= application.getInitParameter("message") %>
<%=page %>, <%=this %>
</body>
</html>