<%@page import="ezen.common.database.DaoFactory"%>
<%@page import="ezen.member.JdbcMemberDao"%>
<%@page import="ezen.member.MemberDao"%>
<%@page import="ezen.member.Member"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="*" name="member"/>

<%
//MemberDao memberDao = new JdbcMemberDao();
MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
memberDao.create(member);
//member = memberDao.findByUser(member.getId(), member.getPasswd());

// 회원 가입 정보 보여주는 페이지로 이동
response.sendRedirect("register-result.jsp");
%>
















