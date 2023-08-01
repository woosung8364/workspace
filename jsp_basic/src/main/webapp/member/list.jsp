<%@page import="ezen.member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
//테스트를 위한 콜렉션 생성 및 스코프 객체에 저장
List<String> teams = new ArrayList<>();

List<Member> members = new ArrayList<Member>();
members.add(new Member("songwoosung" , "1111" , "양우성" , "seo8362@naver.com" , "www"));
members.add(new Member("songwoosung2" , "1121" , "양우성" , "seo8362@naver.com" , "ddd"));
members.add(new Member("songwoosung3" , "1111" , "양우성" , "seo8362@naver.com" , "dddw"));
members.add(new Member("songwoosung4" , "1111" , "양우성" , "seo8362@naver.com" , "ddwq"));

request.setAttribute("members", members);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

 <ul>
 <c:forEach items = "${teams}" var="team">
    <li>${teams}</li>
 </c:forEach>
 
 </ul>
 
 
 회원 목록
 <table border="1">
 <c:forEach items="${members}" var="members" varStatus="loop">
  	<tr>
  		<td>${loop.index}</td>
  		<td>${members.id}</td>
  		<td>${members.name}</td>
  		<td>${members.email}</td>
  	</tr>
 </c:forEach>
 </table>
 
 
 
</body>
</html>