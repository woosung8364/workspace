<%@ page contentType="text/html; charset=utf-8"%>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:forward page="../hello.jsp">
	<jsp:param value="bangry" name="id" />
	<jsp:param value="송우성" name="name" />
</jsp:forward>
