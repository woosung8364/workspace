<%@page import="ezen.shopping.cart.Product"%>
<%@page import="ezen.shopping.cart.ShoppingCart"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<%
if(cart == null){
%>
카트에 아무것도 없데이....
<%	
}else{
%>
<ul>
	<%
	for(Product product : cart.findAll()){
	%>
	<li><%=product.getName() %> (<%=product.getCount() %>개)</li>
	<%
	}
	%>
</ul>
<%	
}
%>


</body>
</html>


