<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jspf" %>
<%--내부에서는 동작함--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mini board</title>
</head>
<body>
처음만드는 웹 게시판
<%
if(session.getAttribute("user")!=null){
	Map<String,Object> user = (Map<String,Object>)session.getAttribute("user");
	out.println(user.get("uiName")+"님 반갑습니다.<br>");
	out.println("<a href=\"/views/user/logout\">로그아웃</a>");
	out.println("<a href=\"/board/list\">게시판</a>");
}else{
%>
<a href="/views/user/login">로그인</a>
<a href="/views/user/signup">회원가입</a>
<%
}
%>

</body>
</html>