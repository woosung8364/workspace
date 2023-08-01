<%@ page contentType="text/html; charset=utf-8" %>

<%
// 세션 삭제
session.invalidate();
response.sendRedirect(application.getContextPath() + "/index.jsp");
%>