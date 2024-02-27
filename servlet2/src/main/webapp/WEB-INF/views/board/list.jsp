<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<!-- 부트스트렙5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<h2>목록</h2>
	<form action="<c:url value="/board/list"/>" class="mb-3 mt-3">
		<div class="input-group">
			<select name="type">
				<option value="all">전체</option>
				<option value="title">제목</option>
				<option value="writer">작성자</option>
			</select>
	    	<input type="text" class="form-control" placeholder="검색어" name="search">
	    	<button class="btn btn-outline-primary" type="submit">검색</button> 
	  	</div>
	</form>
	<table class="table table-hover">
 		<thead>
			<tr>
				<th>번호</th>
				<th>게시판</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bo_num}</td>
					<td>${board.community.co_name}</td>
					<td>
						<a href="<c:url value=""/>">${board.bo_title}</a>
					</td>
					<td>
						<a href="<c:url value=""/>">${board.bo_me_id}</a>
					</td>
					<td>${board.bo_view}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="write"/>"><button class="btn btn-primary">게시글 등록</button></a>
</div>


</body>
</html>