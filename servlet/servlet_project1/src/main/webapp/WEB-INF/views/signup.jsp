<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>" method="post">
		<label id="id">아이디</label>
		<input type="text" name="id" placeholder="아이디">
		<br>
		<label id="pw">비밀번호</label>
		<input type="password" name="pw" placeholder="비밀번호"> 
		<br>
		<label id="pw2">비밀번호 확인</label>
		<input type="password" name="pw2" placeholder="비밀번호 재입력"> 
		<br>
		<label id="email">이메일</label>
		<input type="email" name="email" placeholder="이메일">
		<br>
		<button type="submit">회원가입</button>
	</form>

</body>
</html>