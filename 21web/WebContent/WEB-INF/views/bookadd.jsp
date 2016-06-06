<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管系统</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}

td {
	text-align: left;
}
</style>
</head>
<body>
	<%@ include file="nav.jsp"%>

	<div class="container">

		<div class="starter-template">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">添加新书</h3>
				</div>
				<div class="panel-body">
					<form id="signupForm" id="newBook" method="post"
						class="form-horizontal" action="/save" novalidate="novalidate">
						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">序号:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="code"
									placeholder="请输书籍序号">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="title">书名:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="title"
									placeholder="请输入书名">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="author">作者:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="author"
									placeholder="请输入作者">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="publishing">出版社:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="publishing"
									placeholder="请输入出版社">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="total">数量:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="total"
									placeholder="请输入数量">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button type="submit" id="bt" class="btn btn-primary"
									name="signup" value="添加">
									<strong>添加</strong>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

	<script src="/static/js/jquery-1.11.3.min.js"></script>
	<script src="/static/js/jquery.validate.min.js"></script>
	<script>
		$(function() {
			$("#bookhome").addClass("active");
			$("#signupForm")
					.validate(
							{
								rules : {
									code : "required",
									title : "required",
									author : "required",
									publishing : "required",
									total : {
										required : true,
										digits : true
									}
								},
								messages : {
									code : "",
									title : "",
									author : "",
									publishing : "",
									total : ""

								},
								errorElement : "span",
								highlight : function(element, errorClass,
										validClass) {
									$(element).parents(".col-sm-5").addClass(
											"has-error").removeClass(
											"has-success");
								},
								unhighlight : function(element, errorClass,
										validClass) {
									$(element).parents(".col-sm-5").addClass(
											"has-success").removeClass(
											"has-error");
								}
							});
		});
	</script>
</body>
</html>