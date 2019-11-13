<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/user/signup" onsubmit="return checkForm()"><%--이벤트만 모두 소문자!!,받고 false리턴을 해줘야 실행을 함 --%>
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="uiTitle" id="uiTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="uiId" id="uiId"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="password" name="uiPwd" id="uiPwd"></td>
			</tr>
			<tr>
			<th colspan="2"><button>회원가입</button></th><%--type="button" onclick="checkForm()저번 방식 폼이, 서밋을 해줌--%>
			</tr>
		</table>
	</form>
	<script>
	function checkForm(){
		var uiName = document.getElementById("uiName").value;//스페이스(화이트스페이스)
		if(uiName.trim().length<2){
			alert("이름은 2글자 이상힙니다.");
			document.getElementById("uiName").value="";
			document.getElementById("uiName").focus();
			return false;
			
		}
		var uiIdObj = document.getElementById("uiId");
		if(uiIdObj.value.trim().length<5){
			alert("아이디는 5글자 이상입니다.")
			uiIdObj.value="";
			uiIdObj.focus();
			return false;
		}
		var uiPwdObj = document.getElementById("uiPwd");
		if(uiPwdObj.value.trim().length<5){
			alert("비밀번호는 5글자 이상입니다.")
			uiPwdObj.value="";
			uiPwdObj.focus();
			return false;
		}
		var uiPwdCheckObj = document.getElementById("uiPwdCheck");
		if(uiPwdObj.value!=uiPwdCheckObj.value){
			alert("비밀번호 체크와 비밀번호가 일치하지 않습니다.")
			uiPwdCheckObj.value="";
			uiPwdCheckObj.focus();
			return false;
		}
		return true;//1. 조건이 이름이 빈문자,몇글자이상,이하,비밀번호 확인에서 틀릴때, 조건이 맞으면 ture
	}
	</script>
</body>
</html>