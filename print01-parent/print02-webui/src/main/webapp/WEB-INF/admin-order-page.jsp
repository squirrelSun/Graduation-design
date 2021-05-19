<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="css/pagination.css" />
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<script type="text/javascript">
	$(function(){
		initPagination();
		$('[data-toggle="popover"]').popover()
	});
	function initPagination() {
		var totalRecord = ${requestScope.pageInfo.total};
		var properties = {
			num_edge_entries: 3,								
			num_display_entries: 5,								
			callback: pageSelectCallback,						
			items_per_page: ${requestScope.pageInfo.pageSize},	
			current_page: ${requestScope.pageInfo.pageNum - 1},	
			prev_text: "上一页",									
			next_text: "下一页"									
		};
		$("#Pagination").pagination(totalRecord, properties);
	}
	function pageSelectCallback(pageIndex, jQuery) {
		var pageNum = pageIndex + 1;
		window.location.href = "order/get/page.html?pageNum="+pageNum+"&keyword=${param.keyword}";
		return false;
	}
	
</script>
<body>

	<%@ include file="/WEB-INF/include-nav-admin.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar-admin.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 订单列表
						</h3>
					</div>
					<div class="panel-body">
						<form action="order/get/page.html" method="post"
							class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input name="keyword" class="form-control has-success"
										type="text" placeholder="请输入查询条件">
								</div>
							</div>
							<button type="submit" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
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
										<th width="100">详情</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty requestScope.pageInfo.list }">
										<tr>
											<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
										</tr>
									</c:if>
									<c:if test="${!empty requestScope.pageInfo.list }">
										<c:forEach items="${requestScope.pageInfo.list }" var="order"
											varStatus="myStatus">
											<tr>
												<td>${myStatus.count }</td>
												<td>${order.orderNum }</td>
												<td>${order.payOrderNum }</td>
												<td>${order.orderAmount }</td>
												<td>${order.orderRemark }</td>
												<td><c:if test="${order.orderStatus == 0 }">未支付</c:if>
													<c:if test="${order.orderStatus == 1 }">已支付</c:if> <c:if
														test="${order.orderStatus == 2 }">异常</c:if></td>
												<td>${order.updateTime }</td>
												<td><button type="button"
														class="btn btn-xs btn-success" data-placement="left"
														data-toggle="popover" title="订单详情" data-html="true"
														data-content="<div><div>
														<table class='table table-bordered'> 
															<tbody>
																<tr>
																	<td>会员名称</td>
																	<td>${order.memberName }</td>
																</tr>
																<tr>
																	<td>会员状态</td>
																	<td><c:if test="${order.memberIsDelete == 0 }">正常</c:if>
																		<c:if test="${order.memberIsDelete == 1 }">注销</c:if></td>
																</tr>
																<tr>
																	<td>机器名称</td>
																	<td>${order.machineName }</td>
																</tr>
																<tr>
																	<td>机器状态</td>
																	<td><c:if test="${order.machineIsDelete == 0 }">在线</c:if>
																		<c:if test="${order.machineIsDelete == 1 }">下线</c:if>
																	</td>
																</tr>
																<tr>
																	<td>文档名称</td>
																	<td>${order.documentName }</td>
																</tr>
																<tr>
																	<td>文档状态</td>
																	<td><c:if test="${order.documentStatus == 0 }">待打印</c:if>
																		<c:if test="${order.documentStatus == 1 }">已打印</c:if>
																		<c:if test="${order.documentStatus == 2 }">异常</c:if></td>
																</tr>
															</tbody>
														</table>
													</div></div>">
														<i class=" glyphicon glyphicon-check"></i>
													</button></td>
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