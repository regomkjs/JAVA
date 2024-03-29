<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 부트스트렙5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="signup"/>" method="post">
		<h1>회원가입</h1>
   		<div class="mb-3 mt-3">
   			<label for="id">아이디:</label>
   			<input type="text" class="form-control" id="id" placeholder="아이디 입력" name="id">
		</div>
		<div class="mb-3 mt-3">
			<button type="button" class="btn btn-outline-success" id="idCheck">아이디 중복 검사</button>
		</div>
   		<div class="mb-3">
   			<label for="pw">비밀번호:</label>
   			<input type="password" class="form-control" id="pw" placeholder="비밀번호 입력" name="pw">
   		</div>
   		<div class="mb-3">
   			<label for="pw2">비밀번호 확인:</label>
   			<input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인" name="pw2">
   		</div>
   		<div class="mb-3">
   			<label for="email">이메일:</label>
   			<input type="text" class="form-control" id="email" placeholder="이메일 입력" name="email">
   		</div>
   		<button type="submit" class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
<script type="text/javascript">
	let ok = false;
	$("#idCheck").click(function () {
		let id = $("#id").val();
		$.ajax({
			url : '<c:url value="/id/check"/>',
			method : "get",
			async : true,
			data : {
				"id" : id
			},
			success : function (data) {
				if(data == "true"){
					alert("사용 가능한 아이디입니다.");
					ok = true;
				}
				else{
					alert("사용할 수 없는 아이디입니다.");
				}
			},
			error : function (a,b,c) {
				console.error("예외 발생")
			}
		});
	});
	
	$("#id").change(function () {
		ok = false;
	});
	
	$("form").submit(function () {
		if(!ok){
			alert("먼저 아이디 중복검사를 해주세요.")
			return false;
		}
	});
</script>

</body>
</html>