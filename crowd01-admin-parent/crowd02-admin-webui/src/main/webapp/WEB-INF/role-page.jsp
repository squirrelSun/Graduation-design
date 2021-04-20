<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="css/pagination.css" />
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<link rel="stylesheet" href="ztree/zTreeStyle.css" />
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="crowd/my-role.js"></script>
<script type="text/javascript">
	$(function() {
		// 初始化数据
		window.pageNum = 1;
		window.pageSize = 5;
		window.keyword = "";
		// 分页显示
		generatePage();
		// 查询按钮绑定单击响应函数
		$("#searchBtn").click(function() {
			// 获取关键词数据
			window.keyword = $("#keywordInput").val();
			// 刷新页面
			generatePage();
		});
		// 新增按钮打开模态框
		$("#showAddModalBtn").click(function() {
			$("#addModal").modal("show");
		});
		// 新增模态框中的保存按钮绑定单击响应函数
		$("#saveRoleBtn").click(function() {
			// 获取文本框中的输入
			var roleName = $.trim($("#addModal [name=roleName]").val());
			// 发送Ajax请求
			$.ajax({
				"url" : "role/save.json",
				"type" : "post",
				"data" : {
					"name" : roleName
				},
				"dataType" : "json",
				"success" : function(response) {
					var result = response.operationResult;
					if (result == "SUCCESS") {
						layer.msg("操作成功！");
						// 重新加载分页数据
						window.pageNum = 99999999;
						generatePage();
					}
					if (result == "FAILED") {
						layer.msg("操作失败！" + response.operationMessage);
					}
				},
				"error" : function(response) {
					layer.msg(response.status + " " + response.statusText);
				}
			});
			// 关闭模态框
			$("#addModal").modal("hide");
			// 清空模态框
			$("#addModal [name=roleName]").val("");
		});
		// 打开更新模态框
		$("#rolePageBody").on("click", ".pencilBtn", function() {
			$("#editModal").modal("show");
			// 获取表格中当前行中的角色名称
			var roleName = $(this).parent().prev().text();
			// 获取当前角色的id
			window.roleId = this.id;
			$("#editModal [name=roleName]").val(roleName);
		});
		// 更新模态框中的更新按钮绑定单击响应函数
		$("#updateRoleBtn").click(function() {
			// 获取新的角色名称
			var roleName = $("#editModal [name=roleName]").val();
			// 发送Ajax请求
			$.ajax({
				"url" : "role/update.json",
				"type" : "post",
				"data" : {
					"id" : window.roleId,
					"name" : roleName
				},
				"dataType" : "json",
				"success" : function(response) {
					var result = response.operationResult;
					if (result == "SUCCESS") {
						layer.msg("操作成功！");
						// 重新加载分页数据
						generatePage();
					}
					if (result == "FAILED") {
						layer.msg("操作失败！" + response.operationMessage);
					}
				},
				"error" : function(response) {
					layer.msg(response.status + " " + response.statusText);
				}
			});
			// 关闭模态框
			$("#editModal").modal("hide");
		});
		// 删除模态框中的确认删除按钮
		$("#removeRoleBtn").click(function() {
			// 获取roleIdArray，转换为JSON字符串
			var requestBody = JSON.stringify(window.roleIdArray);
			// 发送Ajax请求
			$.ajax({
				"url" : "role/remove/by/role/id/array.json",
				"type" : "post",
				"data" : requestBody,
				"contentType" : "application/json;charset=UTF-8",
				"dataType" : "json",
				"success" : function(response) {
					var result = response.operationResult;
					if (result == "SUCCESS") {
						layer.msg("操作成功！");
						// 重新加载分页数据
						generatePage();
					}
					if (result == "FAILED") {
						layer.msg("操作失败！" + response.operationMessage);
					}
				},
				"error" : function(response) {
					layer.msg(response.status + " " + response.statusText);
				}
			});
			// 关闭模态框
			$("#confirmModal").modal("hide");
		});
		// 单条删除按钮绑定单击响应函数
		$("#rolePageBody").on("click", ".removeBtn", function() {
			// 获取角色名称
			var roleName = $(this).parent().prev().text();
			// 创建role存入数组
			var roleArray = [ {
				roleId : this.id,
				roleName : roleName
			} ];
			// 调用打开删除模态框函数
			showConfirmModal(roleArray);
		});
		// 多选框checkbox绑定单击响应函数
		$("#summaryBox").click(function() {
			// 获取多选框状态
			var currentStatus = this.checked;
			// 当前多选框的状态设置其他多选框
			$(".itemBox").prop("checked", currentStatus);
		});
		// 全选、全不选
		$("#rolePageBody").on("click", ".itemBox", function() {
			// 获取已选中的.itemBox数量
			var checkedBoxCount = $(".itemBox:checked").length;
			// 获取全部.itemBox数量
			var totalBoxCount = $(".itemBox").length;
			// 比较结果设置checkbox
			$("#summaryBox").prop("checked", checkedBoxCount == totalBoxCount);
		});
		// 批量删除的按钮绑定单击响应函数
		$("#batchRemoveBtn").click(function() {
			var roleArray = [];
			// 遍历选中的多选框
			$(".itemBox:checked").each(function() {
				var roleId = this.id;
				// 获取角色名称
				var roleName = $(this).parent().next().text();
				roleArray.push({
					"roleId" : roleId,
					"roleName" : roleName
				});
			});
			// 检查roleArray长度
			if (roleArray.length == 0) {
				layer.msg("请至少选择一个执行删除");
				return;
			}
			// 调用打开删除模态框函数
			showConfirmModal(roleArray);
			${"summaryBox"}.checked = false;
		});
	});
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
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input id="keywordInput" class="form-control has-success"
										type="text" placeholder="请输入查询条件">
								</div>
							</div>
							<button id="searchBtn" type="button" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button id="batchRemoveBtn" type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<button id="showAddModalBtn" type="button" class="btn btn-primary"
							style="float: right;">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input id="summaryBox" type="checkbox"></th>
										<th>名称</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody id="rolePageBody"></tbody>
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<div id="Pagination" class="pagination">
												<!-- 这里显示分页 -->
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
	<%@ include file="/WEB-INF/modal-role-add.jsp"%>
	<%@include file="/WEB-INF/modal-role-edit.jsp"%>
	<%@include file="/WEB-INF/modal-role-confirm.jsp"%>
</body>
</html>