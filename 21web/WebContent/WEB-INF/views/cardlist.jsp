<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
			<a href="/cardadd" style="float: right;" class="btn btn-primary">新建借书卡</a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>编号</th>
						<th>卡号</th>
						<th>姓名</th>
						<th>电话</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cd" items="${cardList}">
						<tr>
							<th scope="row">${cd.id}</th>
							<td>${cd.code}</td>
							<td>${cd.name}</td>
							<td>${cd.tel}</td>
							<td>
								<button data-id="${cd.id}" type="button"
									class="btn btn-danger btn-xs delLink">删除</button> <a
								href="/edit?id=${cd.id}">
									<button data-id="${cd.id}" type="button"
										class="btn btn-success btn-xs">编辑</button>
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
