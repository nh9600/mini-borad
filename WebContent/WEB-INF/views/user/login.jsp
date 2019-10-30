<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post"action="/user/login">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="uiId" id="uiId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="uiPwd" id="uiPwd"></td>
		</tr>
		<tr>
			<th colspan="2"><button>로그인</button></th>
		</tr>
	</table>
	</form>
</body>
</html>