<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<body>
	<%@include file="/WEB-INF/include-nav-merchant.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-xs-offset-1 main">
				<h1 class="page-header">商户界面</h1>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<table class="table">
					<thead>
						<tr>
							<td>邮箱</td>
							<td>状态</td>
							<td>注册日期</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sessionScope.member.memberEmail }</td>
							<td><c:if test="${sessionScope.member.memberStatus == 0}">
						正常
					</c:if> <c:if test="${sessionScope.member.memberStatus == 1}">
						异常
					</c:if></td>
							<td>${sessionScope.member.updateTime }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


		<div class="row">
			<div class="col-md-10 col-xs-offset-1 main">
				<h3 class="page-header">文档信息</h3>
				<input type="text" name="updocu" style="display: none;" />
				<button type="button" id="uploadBtn4"
					class="btn btn-primary btn-lg active">上传文档</button>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>名称</td>
							<td>状态</td>
							<td>大小</td>
							<td>下载链接</td>
							<td>上传日期</td>
							<td>是否存在</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty sessionScope.document }">
							<tr>
								<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
							</tr>
						</c:if>
						<c:if test="${! empty sessionScope.document }">
							<c:forEach items="${sessionScope.document }" var="d"
								varStatus="myStatus">
								<tr>
									<td>${myStatus.count }</td>
									<td>${d.documentName }</td>
									<td><c:if test="${d.documentStatus == 0}">待打印</c:if> <c:if
											test="${d.documentStatus == 1}">已打印</c:if> <c:if
											test="${d.documentStatus == 2}">异常</c:if></td>
									<td>${d.documentSize }</td>
									<td><a href="${d.documentUrl }">点击下载</a></td>
									<td>${d.updateTime }</td>
									<td><c:if test="${d.isDelete == 0}">存在</c:if> <c:if
											test="${d.isDelete == 1}">已删除</c:if></td>
									<td><a href="document/print/${d.id }.html"
										class="btn btn-success btn-xs"> <i
											class=" glyphicon glyphicon-check"></i>
									</a> <a href="document/remove/${d.id }.html"
										class="btn btn-danger btn-xs"> <i
											class=" glyphicon glyphicon-remove"></i>
									</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

		</div>

	</div>
	<script src="jquery/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="script/docs.min.js"></script>
	<script src="script/back-to-top.js"></script>
	<script src="script/echarts.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#uploadBtn4").click(function() {
				$("[name=updocu]").click();
			});
			$("[name=updocu]").change(function(event) {
				var file = event.target.files[0];
				var url = window.url || window.webkitURL;
				var path = url.createObjectURL(file);
				$(this).next().next().next().next().attr("src", path).show();
				var formData = new FormData();
				formData.append("returnPicture", file);
				$.ajax({
					"url" : "[[@{/document/create/upload.json}]]",
					"type" : "post",
					"data" : formData,
					"contentType" : false,
					"processData" : false,
					"dataType" : "json",
					"success" : function(response) {
						var result = response.operationResult;
						if (result == "SUCCESS") {
							$("[name=updocu]").val(response.queryData);
							alert("上传成功！");
						}
						if (result == "FAILED") {
							alert(response.operationMessage);
						}
					},
					"error" : function(response) {
						alert(response.status + " " + response.statusText);
					}
				});
			});
		});
	</script>
</body>
</html>
