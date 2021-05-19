<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<body>
	<%@include file="/WEB-INF/include-nav-member.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-xs-offset-1 main">
				<h1 class="page-header">会员界面</h1>
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				${sessionScope.order } <br>
				${sessionScope.document }
			</div>
			<div class="col-md-10 col-xs-offset-1 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 订单列表
						</h3>
					</div>
					<div class="panel-body">
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th>订单号</th>
										<th>支付宝流水号</th>
										<th>订单金额</th>
										<th>订单备注</th>
										<th>订单状态</th>
										<th>创建时间</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${sessionScope.order } == null">
										<tr>
											<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
										</tr>
									</c:if>
									<c:if test="${! empty sessionScope.order }">
										<c:forEach items="${sessionScope.order }" var="o"
											varStatus="myStatus">
											<tr>
												<td>${myStatus.count }</td>
												<td>${o.id }</td>
												<td>${o.payOrderNum }</td>
												<td>${o.orderAmount }</td>
												<td>${o.orderRemark }</td>
												<td><c:if test="${o.orderStatus == 0 }">未支付</c:if> <c:if
														test="${o.orderStatus == 1 }">已支付</c:if> <c:if
														test="${o.orderStatus == 2 }">异常</c:if></td>
												<td>${o.updateTime }</td>

											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="10" align="center">
											<div id="Pagination" class="pagination">
												<!-- 显示分页 -->
											</div>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>
