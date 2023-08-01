<%@page import="ezen.member.Member"%>
<%--<%@page isELIgnored="true"%> --%>
<%@ page contentType="text/html; charset=utf-8" %>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="name" name="member" value="김기정"/>
<jsp:setProperty property="id" name="member" value="bangry"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
이름 : ${sessionScope.member.name}<br>
이름 : ${member.name}<br>
파라미터로 전달된 이름 : ${param.name}<br>
파라미터로 전달된 관심사항 : ${paramValues.interest['0']}<br>
파라미터로 전달된 관심사항 : ${paramValues.interest['1']}<br>
헤더정보(user-agent) : ${header['User-Agent']}<br>

헤더정보(쿠키정보) : ${headerValues.Cookie[0]}<br>
헤더정보(쿠키값) : ${cookie['JSESSIONID'].value}<br>
초기파라메터 : ${initParam['message']}<br>

브라우저의 요청방식 : ${pageContext.request.method}

<%= ((Member)session.getAttribute("member")).getEmail() %>
${member.email }

<%-- EL에서 빈의 메소드 호출도 가능합니다.. --%>
${member.setEmail("bangry@gmail.com") }<br>
${member.email }


</body>
</html>





