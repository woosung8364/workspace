<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
// 세션 삭제
session.invalidate();
//response.sendRedirect("/index.jsp");
%>

<c:redirect url="/index.jsp"/>