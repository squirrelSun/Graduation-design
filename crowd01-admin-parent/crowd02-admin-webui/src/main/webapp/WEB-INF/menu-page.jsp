<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="ztree/zTreeStyle.css" />
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="crowd/my-menu.js"></script>
<script type="text/javascript">
	$(function() {
		// 初始化树结构
		generateTree();
		// 添加子节点按钮绑定单击响应函数
		$("#treeDemo").on("click",".addBtn",function(){
			// 将当前节点的id保存到全局变量
			window.pid = this.id;
			// 打开模态框
			$("#menuAddModal").modal("show");
			return false;
		});
		
		// 添加子节点模态框中的保存按钮绑定单击响应函数
		$("#menuSaveBtn").click(function(){
			// 收集输入的数据
			var name = $.trim($("#menuAddModal [name=name]").val());
			var url = $.trim($("#menuAddModal [name=url]").val());
			// 单选按钮要定位至被选中的
			var icon = $("#menuAddModal [name=icon]:checked").val();
			// 发送Ajax请求
			$.ajax({
				"url":"menu/save.json",
				"type":"post",
				"data":{
					"pid":window.pid,
					"name":name,
					"url":url,
					"icon":icon
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						// 重新加载树形结构
						generateTree();
					}
					if(result == "FAILED") {
						layer.msg("操作失败！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			// 关闭模态框
			$("#menuAddModal").modal("hide");
			// 清空表单
			$("#menuResetBtn").click();
		});
		
		// 编辑按钮绑定单击响应函数
		$("#treeDemo").on("click",".editBtn",function(){
			// 当前节点的id保存到全局变量
			window.id = this.id;
			// 打开模态框
			$("#menuEditModal").modal("show");
			// 获取zTreeObj对象
			var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
			// 根据id属性查询节点对象
			var key = "id";
			var value = window.id;
			var currentNode = zTreeObj.getNodeByParam(key, value);
			// 回显表单数据
			$("#menuEditModal [name=name]").val(currentNode.name);
			$("#menuEditModal [name=url]").val(currentNode.url);
			$("#menuEditModal [name=icon]").val([currentNode.icon]);
			return false;
		});
		// 更新模态框中的更新按钮绑定单击响应函数
		$("#menuEditBtn").click(function(){
			// 收集表单数据
			var name = $("#menuEditModal [name=name]").val();
			var url = $("#menuEditModal [name=url]").val();
			var icon = $("#menuEditModal [name=icon]:checked").val();
			// 发送Ajax请求
			$.ajax({
				"url":"menu/update.json",
				"type":"post",
				"data":{
					"id": window.id,
					"name":name,
					"url":url,
					"icon":icon
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						generateTree();
					}
					if(result == "FAILED") {
						layer.msg("操作失败！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			// 关闭模态框
			$("#menuEditModal").modal("hide");
		});
		
		// 删除按钮绑定单击响应函数
		$("#treeDemo").on("click",".removeBtn",function(){
			// 将当前节点的id保存到全局变量
			window.id = this.id;
			// 打开模态框
			$("#menuConfirmModal").modal("show");
			// 获取zTreeObj对象
			var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
			// 根据id属性查询节点对象
			var key = "id";
			var value = window.id;
			var currentNode = zTreeObj.getNodeByParam(key, value);
			$("#removeNodeSpan").html("【<i class='"+currentNode.icon+"'></i>"+currentNode.name+"】");
			return false;
		});
		// 删除模态框中的确认按钮绑定单击响应函数
		$("#confirmBtn").click(function(){
			$.ajax({
				"url":"menu/remove.json",
				"type":"post",
				"data":{
					"id":window.id
				},
				"dataType":"json",
				"success":function(response){
					var result = response.result;
					if(result == "SUCCESS") {
						layer.msg("操作成功！");
						generateTree();
					}
					if(result == "FAILED") {
						layer.msg("操作失败！"+response.message);
					}
				},
				"error":function(response){
					layer.msg(response.status+" "+response.statusText);
				}
			});
			// 关闭模态框
			$("#menuConfirmModal").modal("hide");
		});
	});
</script>
<body>
	<%@include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<ul id="treeDemo" class="ztree">
							<!-- 动态生成节点 -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/modal-menu-add.jsp"%>
	<%@include file="/WEB-INF/modal-menu-edit.jsp"%>
	<%@include file="/WEB-INF/modal-menu-confirm.jsp"%>
</body>
</html>
