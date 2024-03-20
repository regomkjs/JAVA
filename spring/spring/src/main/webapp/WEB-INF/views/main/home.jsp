<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
</head>
<body>
	<h1>메인</h1>
	<c:if test="${user == null}">
		<a href='<c:url value="/find/pw"/>'>비번찿기</a>
	</c:if>
	<c:if test="${user != null}">
		<a href='<c:url value="/change/pw"/>'>비번변경</a>
	</c:if>
</body>
</html>
