<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>회원 가입이 완료되었습니다. 가입하신 정보는 아래와 같습니다.</h2>
아이디 : <jsp:getProperty property="id" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
가입일자 : <jsp:getProperty property="regdate" name="member"/><br>
<a href="<%=application.getContextPath() %>/index.jsp">홈으로</a>

</body>
</html>