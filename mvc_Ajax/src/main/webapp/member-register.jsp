<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="ezen.mvcframework.domain.member.dto.Member"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page contentType="text/plain; charset=utf-8" %>
<%
  /*
  BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream() , "utf-8"));
  StringBuilder sb = new StringBuilder();
  String line = null;
  while((line=in.readLine()) != null){
	  sb.append(line);
  }
  System.out.println(sb.toString());
  */
  ObjectMapper objectMapper = new ObjectMapper();
  Member member = objectMapper.readValue(request.getInputStream(), Member.class);
  System.out.println(member);
  //DB 인서트 완료 가정
  
  //가입 완료 후 응답 메시지 전송
  String result = "{\"result\": true ,  \"message\":\"회원 가입 정상 처리\" }";
  out.println(result);
%>
