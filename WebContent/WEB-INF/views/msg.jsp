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
String msg=(String)request.getAttribute("msg");
String url=(String)request.getAttribute("url");
%>
<script>
alert('<%=msg%>');
location.href='<%=url%>';<%--앵커태그와 비슷 누루지않아도 바로 실행--%>
//get 조회할때 리스트 단일 수정 
//post 로그인만 포스트,새로운 생성, 새로운 입렵, 어떠한 리소스를 새로 생성할때, 회원가입
//put 수정 
//delete 삭제
//option 나 해도돼?
</script>
</body>
</html>