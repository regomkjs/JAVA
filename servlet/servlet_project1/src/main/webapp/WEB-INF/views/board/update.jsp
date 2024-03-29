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
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/board/update"/>" method="post" enctype="multipart/form-data">
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
			<textarea rows="10" class="form-control" id="content" name="content" placeholder="내용">${board.bo_content}</textarea>
		</div>
		<div class="mb-3 mt-3" id="attachment">
			<label for="file" class="form-label">첨부파일:</label>
			<c:forEach items="${fileList}" var="file">
				<span class="form-control">${file.fi_ori_name}<a href="#" data-target="${file.fi_num}" class="btn btn-del">X</a></span>
			</c:forEach>
			<c:forEach begin="1" end="${3 - fileList.size()}">
				<input type="file" name="file" class="form-control">
			</c:forEach>
		</div>
		<button class="btn btn-outline-warning col-12">수정</button>
	</form>
</div>

<script type="text/javascript">
	$('[name=content]').summernote({
	    placeholder: '내용',
	    tabsize: 2,
	    height: 400
	  });
	
	let btnDel = document.querySelectorAll(".btn-del");
	let attachment = document.querySelector("#attachment");
	
	btnDel.forEach((element)=>{
		element.onclick = function(e){
			e.preventDefault();
			//input hidden으로 삭제할 첨부파일 번호를 추가
			let num = this.getAttribute("data-target");
			let inputHidden = 
				createElement('input', null,{
					'type' : 'hidden',
					'name' : 'fi_num',
					'value' : `\${num}`
				})
			attachment.prepend(inputHidden);
			//span태그 삭제
			this.parentElement.remove();
			//input태그로 새로운 파일을 받을 준비
			let inputFile = 
				createElement('input', null,{
					'type' : 'file',
					'name' : 'file',
					'class' : 'form-control'
				})
			attachment.append(inputFile)
		}
	});
	
	function createElement(tagName, text, attrs){
		let element = document.createElement(tagName);
		if(text){
			let textNode = document.createTextNode(text);
			element.append(textNode);
		}
		if(!attrs){
			return element;
		}
		for(key in attrs){
			let attr = document.createAttribute(key);
			attr.value = attrs[key];
			element.setAttributeNode(attr);
		}
		return element;
	}
	

</script>
<script type="text/javascript">

</script>

</body>
</html>