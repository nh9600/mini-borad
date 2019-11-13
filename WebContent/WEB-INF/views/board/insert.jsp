<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<%
if(session.getAttribute("user")==null){
	response.sendRedirect("/");
}
if(request.getAttribute("msg")!=null){
%>
<script>
	alert('<%=request.getAttribute("msg")%>');
</script>
<%
}
Map<String,Object> user = (Map<String,Object>)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/board/insert" onsubmit="return checkForm()">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="biTitle" id="biTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="biContent" id="biContent"></textarea></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><%=user.get("uiName") %></td>
		</tr>
		<tr>
			<th colspan="2"><button>글저장</button></th>
		</tr>
	</table>
</form>
<script>
function checkForm(){
	var biTitle = document.getElementById('biTitle').value;
	if(biTitle.trim().length<2){
		alert('제목은 2글자 이상입니다.');
		document.getElementById('biTitle').value = '';
		document.getElementById('biTitle').focus();
		return false;
	}
	var biContentObj = document.getElementById('biContent');
	if(biContentObj.value.trim().length<2){
		alert('게시물 내용은 2글자 이상입니다.');
		biContentObj.value = '';
		biContentObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>