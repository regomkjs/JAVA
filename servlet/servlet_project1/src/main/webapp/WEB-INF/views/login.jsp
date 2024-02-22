<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
	<label id="id">아이디</label>
	<input type="text" name="id"id="id" placeholder="아이디">
	<br>
	<label id="pw">비번</label>
	<input type="password" name="pw" id="pw" placeholder="비밀번호">
	<br>
	<button type="submit">로그인</button>
	</form>
	
	
</body>
</html>