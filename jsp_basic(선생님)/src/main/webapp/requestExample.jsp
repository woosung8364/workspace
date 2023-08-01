<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>request 내장 객체</title>
</head>
<body>
요청 방식 : <%= request.getMethod() %><br>
요청 브라우저 아이피 : <%=request.getRemoteAddr() %>

</body>
</html>