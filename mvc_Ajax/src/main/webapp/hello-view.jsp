<%@ page contentType="text/plain; charset=utf-8" %>
<%
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("name");
%>
<%= name %>님 반갑습니다
