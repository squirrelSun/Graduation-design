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

	<a href="to/member/login/page.html">会员入口</a>
	<br>
	<a href="to/merchant/login/page.html">商户入口</a>
	<br>
	<a href="to/admin/login/page.html">管理员入口</a>

</body>
</html>
