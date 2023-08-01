<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");

//RequestDispatcher rd = application.getRequestDispatcher("");
//rd.forward(request, response);
//rd.include(request, response)

%>

<jsp:forward page="../hello.jsp">
	<jsp:param value="bangry" name="id"/>
	<jsp:param value="김기정" name="name"/>
</jsp:forward>
