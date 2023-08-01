<%@ page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
String id = request.getParameter("id");
String name = request.getParameter("name");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP 프로그래밍</title>
</head>
<body>
<%-- <h2>오늘부터 JSP 웹 프로그래밍입니다.</h2> --%>

<%!
// 서블릿으로 변환 시 인스턴스 변수
int count;

public String getMessage(){
	return "안녕하세요...";
}
%>

<%
// DB로부터 가져온 문자열
String message = "JSP가 최고여...";
//out.println(message);
%>

<%= "김기정바보" %>
<%= getMessage() %>

<%
Calendar today = Calendar.getInstance();
String todayString = String.format("%1$tF %1$tT", today);
out.println(todayString);
%>

<script>
//alert('자바스크립니다..');
</script>

<br>

전달받은 아이디: <%=id %><br>
전달받은 이름: <%=name %><br>




</body>
</html>






