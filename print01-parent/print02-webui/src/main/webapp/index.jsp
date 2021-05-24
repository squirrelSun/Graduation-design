<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>title</title>
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<img src="img/1.png" class="img-rounded img-responsive " width="100%">
		<br> <br> <br> <br> <br> <br>
		<div class="navbar-header">
			<div>
				<a class="navbar-brand"
					style="font-size: 32px; display: block; text-align: center;">校园智能文印平台</a>
				<br> <br> <br> <br>
			</div>
		</div>
		<table class="table" align="center">
			<thead>
				<tr>
					<td width="300"><a
						onclick="window.location.href = 'http://localhost:8080/print02-webui/to/member/login/page.html'"
						style="font-size: 20px;">会员入口</a></td>
					<td width="300"><a
						onclick="window.location.href = 'http://localhost:8080/print02-webui/to/merchant/login/page.html'"
						style="font-size: 20px;">商户入口</a></td>
					<td><a
						onclick="window.location.href = 'http://localhost:8080/print02-webui/to/admin/login/page.html'"
						style="font-size: 20px;">管理员入口</a></td>
				</tr>
			</thead>
		</table>
	</div>

	</div>
</body>
</html>
