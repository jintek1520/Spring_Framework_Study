<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
 src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="jumbotron">글쓰기 회면</h1>
		</div><!--class="row"  -->
		
		<div class="row">
			<form action="/board/insert" method="post">
				<div class="form-group">
					<label for="title">제목</label>
					<input class="form-control" id="title" name="title">
				</div>
				
				<div class="form-group">
					<label for="writer">작성자</label>
					<input class="form-control" id="writer" name="writer">
				</div>
				
				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5"  class="form-control" id="content" name="content"></textarea>
				</div>
			</form>
			
			<div class="form-group">
				<button id="insert_btn_insert" class="btn btn-primary" type="submit">등록</button>
				<button id="insert_btn_list" class="btn btn-info">목록으로 되돌아가기</button>
			</div>
			
		</div>
	
	</div><!--class = container  -->
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#insert_btn_insert").click(function() {
				$("form").submit();
			});
			
			$("#insert_btn_list").click(function() {
				location.assign("/board/list");
			});
		});
	</script>

</body>
</html>