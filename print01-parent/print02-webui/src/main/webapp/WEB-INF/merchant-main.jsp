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
							<td>收款账户</td>
							<td>邮箱</td>
							<td>状态</td>
							<td>注册日期</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sessionScope.merchant.accountNum }</td>
							<td>${sessionScope.merchant.merchantEmail }</td>
							<td><c:if
									test="${sessionScope.merchant.merchantStatus == 0}">
						待审核
					</c:if> <c:if test="${sessionScope.merchant.merchantStatus == 1}">
						正常
					</c:if> <c:if test="${sessionScope.merchant.merchantStatus == 2}">
						异常
					</c:if></td>
							<td>${sessionScope.merchant.updateTime }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-10 col-xs-offset-1 main">
				<h3 class="page-header">机器信息</h3>
				<input type="text" name="addMach" style="display: none;" />
				<button type="button" id="addMachBtn"
					class="btn btn-primary btn-lg active">添加机器</button>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>名称</td>
							<td>状态</td>
							<td>类型</td>
							<td>入网日期</td>
							<td>是否存在</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty sessionScope.machine }">
							<tr>
								<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
							</tr>
						</c:if>
						<c:if test="${! empty sessionScope.machine }">
							<c:forEach items="${sessionScope.machine }" var="m"
								varStatus="myStatus">
								<tr>
									<td>${myStatus.count }</td>
									<td>${m.machineName }</td>
									<td><c:if test="${m.machineStatus == 0}">正常</c:if> <c:if
											test="${m.machineStatus == 1}">使用中</c:if> <c:if
											test="${m.machineStatus == 2}">维护中</c:if> <c:if
											test="${m.machineStatus == 3}">异常</c:if></td>
									<td><c:if test="${m.machineType == 0}">黑白</c:if> <c:if
											test="${m.machineType == 1}">彩色</c:if></td>
									<td>${m.updateTime }</td>
									<td><c:if test="${m.isDelete == 0}">在线</c:if> <c:if
											test="${m.isDelete == 1}">下线</c:if></td>
									<td><a href="order/check/${m.id }.html"
										class="btn btn-success btn-xs"><i
											class=" glyphicon glyphicon-check"></i></a><a
										href="machine/remove/${m.id }.html"
										class="btn btn-danger btn-xs"><i
											class=" glyphicon glyphicon-remove"></i></a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

		</div>

		<div class="row">
			<div class="col-md-10 col-xs-offset-1 main">
				<h3 class="page-header">订单信息</h3>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>订单状态</td>
							<td>订单号</td>
							<td>支付宝流水号</td>
							<td>订单金额</td>
							<td>订单备注</td>
							<td>创建时间</td>
							<td>打印机</td>
							<td>打印文档</td>
							<td>文档状态</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty sessionScope.order }">
							<tr>
								<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
							</tr>
						</c:if>
						<c:if test="${! empty sessionScope.order }">
							<c:forEach items="${sessionScope.order }" var="o"
								varStatus="myStatus">
								<tr>
									<td>${myStatus.count }</td>
									<td><c:if test="${o.orderStatus == 0}">未支付</c:if> <c:if
											test="${o.orderStatus == 1}">已支付</c:if> <c:if
											test="${o.orderStatus == 2}">异常</c:if></td>
									<td>${o.orderNum }</td>
									<td>${o.payOrderNum }</td>
									<td>${o.orderAmount }</td>
									<td>${o.orderRemark }</td>
									<td>${o.updateTime }</td>
									<td>${o.machineName }</td>
									<td>${o.documentName }</td>
									<td><c:if test="${o.documentStatus == 0}">待打印</c:if> <c:if
											test="${o.documentStatus == 1}">已打印</c:if> <c:if
											test="${o.documentStatus == 2}">异常</c:if></td>
									<td><c:if test="${empty o.payOrderNum }">
											<button class="btn btn-success btn-xs" id="btn">
												<i class=" glyphicon glyphicon-check"></i>
											</button>
										</c:if> <c:if test="${! empty o.payOrderNum  }">
											<a href="machine/print/${o.orderId }.html"
												class="btn btn-success btn-xs"> <i
												class=" glyphicon glyphicon-check"></i>
											</a>
										</c:if></td>
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
			$("#btn").click(function() {
				alert("用户未支付订单！！！等稍后重试");
			});
			$("#addMachBtn").click(function() {
				$("#addModal").modal("show");
			});
			$("#saveMachineBtn").click(
					function() {
						var machineName = $.trim($(
								"#addModal [name=machineName]").val());
						var machineType = 1;
						$.ajax({
							"url" : "machine/save.json",
							"type" : "post",
							"data" : {
								"machineName" : machineName,
								"machineType" : machineType
							},
							"dataType" : "json",
							"success" : function(response) {
								var result = response.operationResult;
								if (result == "SUCCESS") {
									alert("添加成功！");
									window.location.reload();
								}
								if (result == "FAILED") {
									layer.msg("操作失败！"
											+ response.operationMessage);
								}
							},
							"error" : function(response) {
								alert(response.status + " "
										+ response.statusText);
							}
						});
						$("#addModal").modal("hide");
						$("#addModal [name=machineName]").val("");
					});
		});
	</script>
	<%@ include file="/WEB-INF/modal-role-add.jsp"%>
</body>
</html>
