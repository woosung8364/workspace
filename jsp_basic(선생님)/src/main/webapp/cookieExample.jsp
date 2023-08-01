<%@ page contentType="text/html; charset=utf-8" %>
<%
Cookie counterCookie = null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for (Cookie cookie : cookies){
		if(cookie.getName().equalsIgnoreCase("couter")){
			counterCookie = cookie;
		}		
	}
}
if(counterCookie == null){
	// 쿠키 생성
	counterCookie = new Cookie("couter", "0");
}

counterCookie.setMaxAge(60*60*24*100);// 초단위 -> 100일 저장
counterCookie.setPath("/");

int counter = Integer.parseInt(counterCookie.getValue());
counter++;
counterCookie.setValue(String.valueOf(counter));

// 응답헤더에 쿠키 설정
response.addCookie(counterCookie);
response.sendRedirect("cookieExample2.jsp");
%>