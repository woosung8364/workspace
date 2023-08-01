<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:redirect url="/hello.jsp"></c:redirect>


<%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<a href="/jsp/hello.jsp">hello</a><br>
<a href="../hello.jsp">hello</a><br>


<%-- 동적으로 링크 설정하는 방법들 --%>
<a href="${pageContext.servletContext.contextPath}/hello.jsp">hello</a><br>

<%-- 위의 코드를 단순화 --%>
<a href="<c:url value="/hello.jsp"/>">hello</a><br>

<%-- 특정링크를 변수처리한후 사용하는 방법 --%>
<c:url value="/hello.jsp" var="link"></c:url>
<a href="${link}">hello</a><br>


</body>
</html>
--%>