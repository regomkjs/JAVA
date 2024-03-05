<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container">
		<c:choose>
			<c:when test="${board !=null}">
				<h1>게시글 상세</h1>
				<div class="mb-3 mt-3">
					<label for="community" class="form-label">게시판:</label>
					<input type="text" class="form-control" id="community" name="community" readonly value="${board.community.co_name}">
				</div>
				<div class="mb-3 mt-3">
					<label for="title" class="form-label">제목:</label>
					<input type="text" class="form-control" id="title" name="title" readonly value="${board.bo_title}">
				</div>
				<div class="mb-3 mt-3">
					<label for="writer" class="form-label">작성자:</label>
					<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.bo_me_id}" >
				</div>
				<div class="mb-3 mt-3">
					<label for="view" class="form-label">조회수:</label>
					<input type="text" class="form-control" id="view" name="view" readonly value="${board.bo_view}" >
				</div>
				<div class="mb-3 mt-3">
					<label for="content" class="form-label">내용:</label>
					<textarea rows="10" class="form-control" id="content" name="content" readonly>${board.bo_content}</textarea>
				</div>
				<c:if test="${fileList != null && fileList.size() != 0}">
					<div class="mb-3 mt-3">
						<label for="file" class="form-label">첨부파일:</label>
						<c:forEach items="${fileList}" var="file">
							<div>
								<a href="<c:url value="/download?filename=${file.fi_name}"/>" class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
							</div>
						</c:forEach>
					</div>
				</c:if>
				
			</c:when>
			<c:otherwise>
				<h1>없는 게시글이거나 삭제된 게시글 입니다.</h1>
			</c:otherwise>
		</c:choose>
		<a href="<c:url value="/board/list"/>" class="btn btn-outline-dark">목록으로</a>
		<a href="<c:url value="/board/update?num=${board.bo_num}"/>" class="btn btn-outline-primary" <c:if test="${user.me_id != board.bo_me_id || user == null}">hidden ="hidden"</c:if>>수정</a>
		<c:url value="/board/delete" var="deleteUrl">
			<c:param name="num" value="${board.bo_num}"/>
		</c:url>		
		<a href="${deleteUrl}" class="btn btn-outline-danger" <c:if test="${ (user.me_id != board.bo_me_id && user.me_authority != 'admin') || user == null}">hidden ="hidden"</c:if>>삭제</a>
	</div>
</body>
</html>