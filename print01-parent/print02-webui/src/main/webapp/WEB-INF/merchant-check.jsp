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
				<h3 class="page-header">可选订单</h3>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<table class="table">
					<thead>
						<tr>
							<td>#</td>
							<td>订单号</td>
							<td>订单金额</td>
							<td>订单备注</td>
							<td>创建时间</td>
							<td>打印文档</td>
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
								<form
									action="merchant/check/order/${o.orderId }/${sessionScope.machineId }.html"
									method="post" class="form-signin" role="form">
								<tr>
									<td>${myStatus.count }</td>
									<td>${o.orderNum }</td>
									<td><input type="text" name="orderPay"
										class="form-control" id="orderPay" placeholder="请输入订单金额"></td>
									<td>${o.orderRemark }</td>
									<td>${o.updateTime }</td>
									<td>${o.documentName }</td>
									<td>
										<button type="submit" class="btn btn-success btn-xs">
											<i class=" glyphicon glyphicon-check"></i>
										</button>
									</td>
								</tr>

							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>
