<%@ page contentType="text/html; charset=utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
Cookie counterCookie = null;
Cookie[] cookies = request.getCookies();

if(cookies != null){
	for (Cookie cookie : cookies){
		//.equalsIgnoreCase : 대소문자를 구분하지 않고 비교
		if(cookie.getName().equalsIgnoreCase("counter")){
			//쿠키의 값 읽어오기
			counterCookie = cookie;
		}
	}
	
}

if(counterCookie == null){
	//쿠키 생성
	counterCookie = new Cookie("counter" , "0");
	//쿠키 유효기간 설정 100일
	
}

counterCookie.setMaxAge(60*60*24*100); 
counterCookie.setPath("/");


int counter = Integer.parseInt(counterCookie.getValue());
counter++;
counterCookie.setValue(String.valueOf(counter));

response.addCookie(counterCookie);
response.sendRedirect("CookieExample2.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

</body>
</html>