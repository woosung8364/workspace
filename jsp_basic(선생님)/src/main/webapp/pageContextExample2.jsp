<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%--공유된 아이디 : <%=request.getAttribute("id") %> --%>
<%--공유된 아이디 : <%=session.getAttribute("id") %> --%>
<%--공유된 아이디 : <%=application.getAttribute("id") %> --%>
<%--공유된 아이디 : <%=pageContext.getAttribute("id") %> --%>
공유된 아이디 : <%=pageContext.getAttribute("id", PageContext.REQUEST_SCOPE) %>
공유된 아이디 : <%=pageContext.findAttribute("id") %>

</body>
</html>