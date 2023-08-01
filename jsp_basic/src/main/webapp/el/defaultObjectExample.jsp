<%@ page contentType="text/html; charset=utf-8"%>
<%--<%@ page isELIgnored="true">  --%>


<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="name" name="member" value="송우성"/>
<jsp:setProperty property="id" name="member" value="song8364"/>

<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title></title>
</head>
<body>
이름 : ${sessionScope.member.name } <br>
이름 : ${member.name } <br>
파라미터로 전달된 이름 : ${param.name}<br>
파라미터로 전달된 관심사항 : ${paramValues.interest['0']}<br>
파라미터로 전달된 관심사항 : ${paramValues.interest['1']}<br>
헤더정보(User-agent) : ${header['User-Agent']}<br>
헤더정보(쿠키정보) : ${headerValues.Cookie[0]}<br>
헤더정보(쿠키정보) : ${cookie['JSESSIONID'].value}<br>
초기파라메터 : ${initParam['message']}

브라우저 요청 방식 : ${pageContext.request.method}

<%-- EL에서 빈의 메소드 호출도 가능합니다 --%>
${member.setEmail("songsusu@naver.com") }<br>
%{member.email}
</body>
</html>