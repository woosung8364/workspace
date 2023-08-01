<%@page import="ezen.common.database.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="ezen.member.Member"%>
<%@page import="ezen.member.JdbcMemberDao"%>
<%@page import="ezen.member.MemberDao"%>


<%
request.setCharacterEncoding("utf-8");
String uid = request.getParameter("uid");
String upw = request.getParameter("upw");

//MemberDao memberDao = new JdbcMemberDao();
MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
Member loginMember=memberDao.findByUser(uid, upw);

request.setAttribute("loginMember", loginMember);

if(loginMember == null){
%>


<c:choose>
<c:when test="${empty loginMember}">
<script>
// 추후 JavaScript2 에서 Ajax를 이용한 비동기 통신 처리
alert('아이디와 비밀번호를 확인하세요');
location.href = '<c:url value="/member/login.jsp"/>';
</script>
</c:when>
<c:otherwise>
	<c:set var="loginId" value="${loginMember.id}" scope="session"/>
	<c:set var="loginName" value="${loginMember.name}" scope="session"/>
	<c:redirect url="/index.jsp" />
</c:otherwise>
</c:choose>





<%
}else{
	session.setAttribute("loginId", loginMember.getId());
	session.setAttribute("loginName", loginMember.getName());
	//index.jsp 에 위임하였음
	response.sendRedirect(application.getContextPath() + "/index.jsp");
}



%>

