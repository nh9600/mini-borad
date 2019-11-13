<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("user")!=null){
	Map<String,Object> user=(Map<String,Object>)session.getAttribute("user");
	out.println(user.get("uiName")+"님 방가~");
}
%>
</body>
</html>