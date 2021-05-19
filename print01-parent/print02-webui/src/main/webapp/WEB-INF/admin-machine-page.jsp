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
		window.location.href = "machine/get/page.html?pageNum="+pageNum+"&keyword=${param.keyword}";
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
							<i class="glyphicon glyphicon-th"></i> 机器列表
						</h3>
					</div>
					<div class="panel-body">
						<form action="machine/get/page.html" method="post"
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
										<th>机器名称</th>
										<th>机器类型</th>
										<th>所属商户</th>
										<th>邮箱地址</th>
										<th>商户状态</th>
										<th>机器状态</th>
										<th>是否可用</th>
										<th>上次操作时间</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty requestScope.pageInfo.list }">
										<tr>
											<td colspan="10" align="center">抱歉！没有查询到您要的数据！</td>
										</tr>
									</c:if>
									<c:if test="${!empty requestScope.pageInfo.list }">
										<c:forEach items="${requestScope.pageInfo.list }"
											var="machine" varStatus="myStatus">
											<tr>
												<td>${myStatus.count }</td>
												<td>${machine.machineName }</td>
												<td><c:if test="${machine.machineType == 0 }">黑白</c:if>
													<c:if test="${machine.machineType == 1 }">彩色</c:if></td>
												<td>${machine.merchantName }</td>
												<td>${machine.merchantEmail }</td>
												<td><c:if test="${machine.merchantStatus == 2 }">异常</c:if>
													<c:if test="${machine.merchantStatus == 1 }">正常</c:if></td>
												<td><c:if test="${machine.machineStatus == 0 }">正常</c:if>
													<c:if test="${machine.machineStatus == 1 }">使用中</c:if> <c:if
														test="${machine.machineStatus == 2 }">维护</c:if> <c:if
														test="${machine.machineStatus == 3 }">异常</c:if></td>
												<td><c:if test="${machine.isDelete == 0 }">在线</c:if> <c:if
														test="${machine.isDelete == 1 }">下线</c:if></td>
												<td>${machine.updateTime }</td>
												<td><a
													href="machine/change/${machine.machineId }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-success btn-xs"> <i
														class=" glyphicon glyphicon-check"></i>
												</a> <a
													href="machine/remove/${machine.machineId }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-danger btn-xs"> <i
														class=" glyphicon glyphicon-remove"></i>
												</a></td>
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