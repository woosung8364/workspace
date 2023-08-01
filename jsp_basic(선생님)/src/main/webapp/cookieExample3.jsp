<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
Cookie nameCookie = new Cookie("name", URLEncoder.encode("김기정--#", "utf-8"));

// 응답헤더에 쿠키 설정
response.addCookie(nameCookie);
response.sendRedirect("cookieExample4.jsp");
%>