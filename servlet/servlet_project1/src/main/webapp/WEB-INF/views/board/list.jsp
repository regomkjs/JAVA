<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
	<h1>게시글 리스트</h1>
	<!-- from태그를 이용하여 검색창 추가 -->
	<form action="<c:url value="/board/list"/>">
		<div class="input-group">
			<select name="type">
				<option value="all" <c:if test='${pm.cri.type == "all"}'>selected</c:if>>전체</option>
				<option value="bo_title" <c:if test='${pm.cri.type == "bo_title"}'>selected</c:if>>제목</option>
				<option value="bo_me_id" <c:if test='${pm.cri.type == "bo_me_id"}'>selected</c:if>>작성자</option>
			</select>
			<input type="text" name="search" value="${pm.cri.search}">
			<button class="btn btn-outline-primary">검색</button>
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
				  		<a href="<c:url value="/board/detail?num=${board.bo_num}"/>">
				  			${board.bo_title}
				  		</a>
				 	 </td>
				  	<td>
				  		<a href="<c:url value="/board/list?type=bo_me_id&search=${board.bo_me_id}"/>">
				  			${board.bo_me_id}
			  			</a>
				  	</td>
				  	<td>${board.bo_view}</td>
				</tr>
	    	</c:forEach>
	    </tbody>
	</table>
	<!-- 서버에서 보낸 PageMaker객체를 이용하여 페이지네이션 구성 -->
	<ul class="pagination justify-content-center">
    	<c:if test="${pm.prev}">
			<li class="page-item">
				<c:url var="prevUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.startPage-1}"/>
				</c:url>
				<a class="page-link" href="${prevUrl}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
				<c:url var="pageUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${i}"/>
				</c:url>
				<a class="page-link" href="${pageUrl}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<c:url var="nextUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
				</c:url>
				<a class="page-link" href="${nextUrl}">다음</a>
			</li>
		</c:if>
  	</ul>
	<a href="<c:url value="/board/insert"/>" class="btn btn-outline-primary">게시글등록</a>	
</div>
</body>
</html>