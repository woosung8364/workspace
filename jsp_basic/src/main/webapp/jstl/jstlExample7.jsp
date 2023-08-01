<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
Date today = new Date();
request.setAttribute("today", today);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
오늘 날짜 <fmt:formatDate value="${today}" pattern="yyyy년 MM월 DD일 hh시 mm분 ss초"/>
</body>
</html>
