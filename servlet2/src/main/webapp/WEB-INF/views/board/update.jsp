<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<!-- 부트스트렙5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action='<c:url value="/board/update"/>' method="post" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<input type="text" hidden="hidden" value="${board.bo_num}" name="num">
		<div class="mb-3 mt-3">
			<label for="community">게시판:</label>
			<select id="community" name="community" class="form-control">
				<c:forEach items="${communityList}" var="community">
					<c:if test='${community.co_name == "공지" && user.me_authority == "admin"}'>
						<option value="${community.co_num}" <c:if test='${board.bo_co_num == community.co_num}'>selected</c:if>>${community.co_name}</option>
					</c:if>
					<c:if test='${community.co_name != "공지"}'>
						<option value="${community.co_num}" <c:if test='${board.bo_co_num == community.co_num}'>selected</c:if>>${community.co_name}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="title">제목:</label>
	  		<input type="text" class="form-control" id="title" placeholder="제목 입력" name="title" value="${board.bo_title}">
		</div>
		<div class="mb-3">
	  		<label for="content">내용:</label>
	  		<div class="mb-3">
	  			<textarea rows="10" class="form-control" id="content" name="content" placeholder="내용">${board.bo_content}</textarea>
	  		</div>
		</div>
		<div class="mb-3" id="attachment">
	  		<label class="form-label">첨부파일:</label>
	  		<c:forEach items="${fileList}" var="file">
	  			<span class="form-control">
		  			${file.fi_ori_name} 
		  			<a href="" class="btn-del" data-target="${file.fi_num}">&times;</a> 
	  			</span>
	  		</c:forEach>
	  		<c:forEach begin="1" end="${3 - fileList.size()}">
	  			<input type="file" class="form-control" name="file">
	  		</c:forEach>
		</div>
		<button type="submit" class="btn btn-primary col-12">수정</button>
	</form>
</div>
<script type="text/javascript">
	$(".btn-del").click(function(e){
		e.preventDefault();
		//x버튼의 data-target값을 가져옴
		let fi_num = $(this).data("target");
		// input file을 추가
		let inputFile = '<input type="file" class="form-control" name="file">';
		$("#attachment").append(inputFile);
		// input hidden을 추가
		let inputHidden = `<input type="hidden" name="fi_num" value="\${fi_num}" >`;
		$("#attachment").prepend(inputHidden);
		//클릭한 x버튼을 갖는 첨부파일을 화면에서 삭제
		$(this).parent().remove();
	});
	
	
</script>
<script type="text/javascript">
$('#content').summernote({
    placeholder: '내용',
    tabsize: 2,
    height: 400,
    toolbar: [
      ['style', ['style']],
      ['font', ['bold', 'underline', 'clear']],
      ['color', ['color']],
      ['para', ['ul', 'ol', 'paragraph']],
      ['table', ['table']],
      ['insert', ['picture']],
      ['view', ['fullscreen', 'codeview', 'help']]
    ]
	});
</script>
</body>
</html>