<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>

<%-- JSTL - 속성 벨류 설정해보기 --%>
<c:set var="score" value="88" scope="request"/>
<%-- member 객체에 속성 설정해보기 --%>
<c:set target="${member}" property="name" value="홍길동"></c:set>
<c:set target="${member}" property="email" value="hongjunpyo2@naver.com"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>


이름 : ${member.name}
email : ${member.email }
</body>
</html>