<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 정보</h2>
<table border="1">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>회원나이</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>${user.user_no}</th>
			<th>${user.user_id}</th>
			<th>${user.user_name}</th>
			<th>${user.user_age}</th>
		</tr>
	</tbody>
</table>
<a href="<c:url value="/"/>">메인페이지로 돌아가기</a>
</body>
</html>