<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
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
					<h3 class="panel-title">修改书籍信息</h3>
				</div>
				<div class="panel-body">
					<form id="signupForm" method="post" class="form-horizontal"
						action="/update" novalidate="novalidate">
						<input type="hidden" name="id" value="${book.id}" />
						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">序号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="code" name="code"
									placeholder="请输书籍序号" value="${book.code}">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="title">书名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="请输入书名" value="${book.title}">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="author">作者</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="请输入作者" value="${book.author}">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="publishing">出版社</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="publishing"
									name="publishing" placeholder="请输入出版社"
									value="${book.publishing}">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="total">数量</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="total" name="total"
									placeholder="请输入数量" value="${book.total}">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="count">剩余数量</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="count" name="count"
									placeholder="请输入剩余数量" value="${book.count}">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button type="submit" class="btn btn-primary" name="signup"
									value="修改">修改</button>
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
									},
									count : {
										required : true,
										digits : true
									}
								},
								messages : {
									code : "",
									title : "",
									author : "",
									publishing : "",
									total : "",
									count : ""

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