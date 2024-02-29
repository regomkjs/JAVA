<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<!-- 부트스트렙5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container">
		<form action="<c:url value="/board/write"/>" method="post">
			<div class="mb-3 mt-3">
				<label for="community">게시판:</label>
				<select id="community" name="community" class="form-control">
					<c:forEach items="${communityList}" var="community">
						<option value="${community.co_num}" <c:if test='${community.co_name == "공지" && user.me_authority != "admin"}'>hidden="hidden"</c:if>>${community.co_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="title">제목:</label>
		  		<input type="text" class="form-control" id="title" placeholder="제목 입력" name="title">
			</div>
			<div class="mb-3">
		  		<label for="content">내용:</label>
		  		<div class="mb-3">
		  			<textarea rows="10" name="content" id="content" class="form-control"></textarea>
		  		</div>
			</div>
			<button type="submit" class="btn btn-primary col-12">등록</button>
		</form>
	</div>
	
	
</body>
</html>