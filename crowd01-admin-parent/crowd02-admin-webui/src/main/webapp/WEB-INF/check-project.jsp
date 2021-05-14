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
		// 初始化
		initPagination();
	});
	// 生成页码导航条
	function initPagination() {
		// 获取总记录数
		var totalRecord = ${requestScope.pageInfo.total};
		// 声明JSON对象存储Pagination的属性
		var properties = {
			num_edge_entries: 3,								// 边缘页数
			num_display_entries: 5,								// 主体页数
			callback: pageSelectCallback,						// 指定回调函数
			items_per_page: ${requestScope.pageInfo.pageSize},	// 每页显示的数量
			current_page: ${requestScope.pageInfo.pageNum - 1},	// 管理页码
			prev_text: "上一页",									// 上一页
			next_text: "下一页"									// 下一页
		};
		$("#Pagination").pagination(totalRecord, properties);
	}
	function pageSelectCallback(pageIndex, jQuery) {
		// 计算pageNum
		var pageNum = pageIndex + 1;
		// 跳转页面
		window.location.href = "project/to/check.html?pageNum="+pageNum+"&keyword=${param.keyword}";
		return false;
	}
	
</script>
<body>

	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i>项目审核
						</h3>
					</div>
					<div class="panel-body">
						<form action="admin/get/page.html" method="post"
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
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th>项目名称</th>
										<th>项目描述</th>
										<th>目标金额（元）</th>
										<th>众筹周期（天）</th>
										<th>项目状态</th>
										<th>创建时间</th>
										<th width="70">审核</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty requestScope.pageInfo.list }">
										<tr>
											<td colspan="12" align="center">抱歉！没有查询到您要的数据！</td>
										</tr>
									</c:if>
									<c:if test="${!empty requestScope.pageInfo.list }">
										<c:forEach items="${requestScope.pageInfo.list }"
											var="project" varStatus="myStatus">
											<tr>
												<td>${myStatus.count }</td>
												<td>${project.projectName }</td>
												<td>${project.projectDescription }</td>
												<td>${project.money }</td>
												<td>${project.day }</td>
												<td><c:if test="${0 eq project.status }">待审核</c:if> <c:if
														test="${1 eq project.status }">进行中</c:if> <c:if
														test="${2 eq project.status }">成功</c:if> <c:if
														test="${3 eq project.status }">失败</c:if></td>
												<td>${project.deploydate }</td>
												<td>
													<button type="button" class="btn btn-success btn-xs">
														<a
															href="http://localhost/project/get/project/detail/${project.id}"><i
															class="glyphicon glyphicon-eye-open"></i></a>
													</button> <a
													href="project/agree/${project.id }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-success btn-xs"> <i
														class=" glyphicon glyphicon-check"></i>
												</a>
												</td>
												<td><a
													href="project/success/${project.id }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-info btn-xs"> <i
														class=" glyphicon glyphicon-ok-sign"></i>
												</a> <a
													href="project/fail/${project.id }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-warning btn-xs"> <i
														class=" glyphicon glyphicon-remove-sign"></i>
												</a> <a
													href="project/remove/${project.id }/${requestScope.pageInfo.pageNum }/${param.keyword }.html"
													class="btn btn-danger btn-xs"> <i
														class=" glyphicon glyphicon-remove"></i>
												</a></td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="12" align="center">
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