<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<base
	href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="layer/layer.js"></script>
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="http://localhost:8080/print02-webui/"
						style="font-size: 32px;">高校文印系统</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">

		<form action="merchant/do/register.html" method="post" class="form-signin"
			role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-log-in"></i> 商户注册
			</h2>
			<p>${requestScope.exception.message }</p>
			<p>${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
			<div class="form-group has-success has-feedback">
				<input type="text" name="loginAcct" class="form-control"
					id="inputSuccess4" placeholder="请输入登录账号" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" name="userpswd" class="form-control"
					id="inputSuccess4" placeholder="请输入登录密码" style="margin-top: 10px;">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" name="username" class="form-control"
					id="inputSuccess4" placeholder="请输入用户昵称" style="margin-top: 10px;">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" name="email" class="form-control"
					id="inputSuccess4" placeholder="请输入邮箱地址" style="margin-top: 10px;">
				<span
					class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="text" name="accountNum" class="form-control"
					id="inputSuccess4" placeholder="请输入收款账户" style="margin-top: 10px;">
				<span
					class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<button type="submit" class="btn btn-lg btn-success btn-block">注册</button>
		</form>
	</div>
</body>
</html>