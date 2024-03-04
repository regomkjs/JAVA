<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/board/update"/>" method="post">
		<h1>게시글 수정</h1>
		<input type="hidden" name="num" value="${board.bo_num}">
		<div class="mb-3 mt-3">
			<label for="community" class="form-label">게시판:</label>
			<select class="form-control" id="community" name="community">
				<c:forEach items="${community}" var="community">
					<c:if test="${user.me_authority == 'admin' && community.co_name ==  '공지'}">
						<option value="${community.co_num}" <c:if test="${board.bo_co_num == community.co_num}">selected</c:if>>${community.co_name} </option>
					</c:if>
					<c:if test="${community.co_name !=  '공지'}">
						<option value="${community.co_num}" <c:if test="${board.bo_co_num == community.co_num}">selected</c:if>>${community.co_name} </option>
					</c:if>	
				</c:forEach>
			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="title" class="form-label">제목:</label>
			<input type="text" class="form-control" id="title" name="title" value="${board.bo_title}">
		</div>
		<div class="mb-3 mt-3">
			<label for="writer" class="form-label">작성자:</label>
			<input type="text" class="form-control" id="writer" name="writer" value="${user.me_id}" readonly="readonly">
		</div>
		<div class="mb-3 mt-3">
			<label for="content" class="form-label">내용:</label>
			<textarea rows="10" class="form-control" id="content" name="content">${board.bo_content}</textarea>
		</div>
		<button class="btn btn-outline-warning col-12">수정</button>
	</form>
</div>



</body>
</html>