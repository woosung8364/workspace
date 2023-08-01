<%@ page contentType="text/html; charset=utf-8" %>
<%-- 데이터 공유를 위해 4개의 스코프 객체에 저장 --%>
<%
request.setAttribute("id", "bangry");

// forward()
RequestDispatcher rd = application.getRequestDispatcher("/pageContextExample2.jsp");
rd.forward(request, response);

//session.setAttribute("id", "bangry");

//application.setAttribute("id", "bbangry");

//pageContext.setAttribute("id", "bbangry");
//RequestDispatcher rd = application.getRequestDispatcher("/pageContextExample2.jsp");
//rd.forward(request, response);


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