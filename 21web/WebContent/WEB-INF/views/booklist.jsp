<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
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
    <%@ include file="nav.jsp" %>
<div class="container">


		<div class="starter-template">
		
			<a href="/save" style="float: right;" class="btn btn-primary">添加书籍</a>
			
			<form action="/findBook" method="get" class="navbar-form navbar-left"
				role="search">
				<div class="form-group">
					<input name="wd" type="text" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>编号</th>
						<th>书号</th>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>总数</th>
						<th>剩余数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList}" >
						<tr>
							<th scope="row">${book.id}</th>
							<td>${book.code}</td>
							<td>${book.title}</td>
							<td>${book.author}</td>
							<td>${book.publishing}</td>
							<td>${book.total}</td>
							<td>${book.count}</td>
							<td>
								<button data-id="${book.id}" type="button" 
									class="btn btn-danger btn-xs delLink">删除</button>
								<a href="/edit?id=${book.id}">
								<button type="button" class="btn btn-success btn-xs">编辑</button>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<script src="/static/js/jquery-1.11.3.min.js"></script>

	<script>
		$(function() {

			$(".delLink").click(function() {

				if (confirm("确定要删除吗？")) {
					var id = $(this).attr("data-id");
					window.location.href = "/delete?id=" + id;
				}

			});

		});
	</script>
</body>
</html>