<%@page import="ezen.shopping.cart.Product"%>
<%@page import="ezen.shopping.cart.ShoppingCart"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
String fruit = request.getParameter("fruits");
int count = Integer.parseInt(request.getParameter("count"));

ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
if(cart == null){
	cart = new ShoppingCart();	
}

Product product = new Product(fruit, count);
cart.addProduct(product);

session.setAttribute("cart", cart);
%>
