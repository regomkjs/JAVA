<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<title>스프링 - 로그인</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="<c:url value="/"/>">main</a>
	  	<!-- Links -->
	  	<ul class="navbar-nav">
	  		<c:if test="${user != null}">
		    	<li class="nav-item">
		      		<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
		    	</li>
		    	<li class="nav-item">
		      		<a class="nav-link" href="<c:url value="/login"/>">로그인</a>
		    	</li>
	  		</c:if>
	
	    	<!-- Dropdown -->
	    	<li class="nav-item dropdown">
		      	<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
		        	Dropdown link
		      	</a>
		      	<div class="dropdown-menu">
			        <a class="dropdown-item" href="#">Link 1</a>
			        <a class="dropdown-item" href="#">Link 2</a>
			        <a class="dropdown-item" href="#">Link 3</a>
		    	</div>
			</li>
		</ul>
	</nav>
<div class="container">
	<form action="<c:url value="/login"/>" method="post">
		<h1>로그인</h1>
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" name="id">
		</div>
		<div class="form-group">
			<label for="pw">비번</label>
			<input type="password" class="form-control" id="pw" name="pw">
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</div>
</body>
</html>