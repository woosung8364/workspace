<%@page import="ezen.member.Member"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");
//String id = request.getParameter("id");
//String name = request.getParameter("name");
//Member member = (Member)request.getAttribute("member");
//if(member == null){
//	member = Class.forName("ezen.member.Member").newInstance();
//}
//member.setId(id);
//member.setName(name);
%>

<jsp:useBean id="member" class="ezen.member.Member" scope="request"/>
<%--<jsp:setProperty property="name" name="member" param="name"/>--%>
<%--<jsp:setProperty property="id" name="member" param="uid"/> --%>
<jsp:setProperty property="*" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<jsp:getProperty property="id" name="member"/><br>
<jsp:getProperty property="name" name="member"/><br>

</body>
</html>


