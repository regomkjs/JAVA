<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/"/>">로고</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
      	<c:if test="${user == null}">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	        </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>


<div class="container">
	<form action="<c:url value="/login"/>" method="post">
		<h1>로그인</h1>
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">아이디:</label>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id">
		</div>
		<div class="mb-3 mt-3">
			<label for="pw" class="form-label">비밀번호:</label>
			<input type="password" class="form-control" id="pw" placeholder="비밀번호" name="pw">
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</div>


</body>
</html>