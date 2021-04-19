// 模态框中显示Auth的树形结构数据
function fillAuthTree() {
	// 发送ajax请求查询数据
	var ajaxReturn = $.ajax({
		"url" : "assgin/get/all/auth.json",
		"type" : "post",
		"dataType" : "json",
		"async" : false
	});
	if (ajaxReturn.status != 200) {
		layer.msg("请求处理出错！响应状态码：" + ajaxReturn.status + " 说明："
				+ ajaxReturn.statusText);
		return;
	}
	// 获取JSON数据
	var authList = ajaxReturn.responseJSON.data;
	var setting = {
		"data" : {
			"simpleData" : {
				"enable" : true,
				"pIdKey" : "categoryId"
			},
			"key" : {
				"name" : "title"
			}
		},
		"check" : {
			"enable" : true
		}
	};
	// 生成树形结构
	$.fn.zTree.init($("#authTreeDemo"), setting, authList);
	// 获取zTreeObj对象
	var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo");
	// 节点展开
	zTreeObj.expandAll(true);
	// 查询已分配的Auth的id组成的数组
	ajaxReturn = $.ajax({
		"url" : "assign/get/assigned/auth/id/by/role/id.json",
		"type" : "post",
		"data" : {
			"roleId" : window.roleId
		},
		"dataType" : "json",
		"async" : false
	});
	if (ajaxReturn.status != 200) {
		layer.msg("请求处理出错！响应状态码：" + ajaxReturn.status + " 说明："
				+ ajaxReturn.statusText);
		return;
	}
	// 获取authIdArray
	var authIdArray = ajaxReturn.responseJSON.data;
	// 树形结构中对应的节点勾选上
	for (var i = 0; i < authIdArray.length; i++) {
		var authId = authIdArray[i];
		var treeNode = zTreeObj.getNodeByParam("id", authId);
		var checked = true;
		var checkTypeFlag = false;
		zTreeObj.checkNode(treeNode, checked, checkTypeFlag);
	}
}

// 生成页面效果
function generatePage() {
	var pageInfo = getPageInfoRemote();
	fillTableBody(pageInfo);
}

// 获取pageInfo
function getPageInfoRemote() {
	var ajaxResult = $.ajax({
		"url" : "role/get/page/info.json",
		"type" : "post",
		"data" : {
			"pageNum" : window.pageNum,
			"pageSize" : window.pageSize,
			"keyword" : window.keyword
		},
		"async" : false,
		"dataType" : "json"
	});
	// 响应状态码
	var statusCode = ajaxResult.status;
	if (statusCode != 200) {
		layer.msg("失败！响应状态码：" + statusCode + " 说明信息：" + ajaxResult.statusText);
		return null;
	}
	// 获取pageInfo
	var resultEntity = ajaxResult.responseJSON;
	// 获取result
	var result = resultEntity.operationResult;
	// 判断是否成功
	if (result == "FAILED") {
		layer.msg(resultEntity.operationMessage);
		return null;
	}
	var pageInfo = resultEntity.queryData;
	return pageInfo;
}

// 填充表格
function fillTableBody(pageInfo) {
	// 清除tbody中的旧内容
	$("#rolePageBody").empty();
	// 没有搜索结果时不显示页码导航条
	$("#Pagination").empty();
	// 判断pageInfo对象是否有效
	if (pageInfo == null || pageInfo == undefined || pageInfo.list == null
			|| pageInfo.list.length == 0) {
		$("#rolePageBody").append(
				"<tr><td colspan='4' align='center'>抱歉！没有查询到您搜索的数据！</td></tr>");
		return;
	}
	// 使用pageInfo的list填充tbody
	for (var i = 0; i < pageInfo.list.length; i++) {
		var role = pageInfo.list[i];
		var roleId = role.id;
		var roleName = role.name;
		var numberTd = "<td>" + (i + 1) + "</td>";
		var checkboxTd = "<td><input id='" + roleId
				+ "' class='itemBox' type='checkbox'></td>";
		var roleNameTd = "<td>" + roleName + "</td>";
		var checkBtn = "<button id='"
				+ roleId
				+ "' type='button' class='btn btn-success btn-xs checkBtn'><i class=' glyphicon glyphicon-check'></i></button>";
		var pencilBtn = "<button id='"
				+ roleId
				+ "' type='button' class='btn btn-primary btn-xs pencilBtn'><i class=' glyphicon glyphicon-pencil'></i></button>";
		var removeBtn = "<button id='"
				+ roleId
				+ "' type='button' class='btn btn-danger btn-xs removeBtn'><i class=' glyphicon glyphicon-remove'></i></button>";
		var buttonTd = "<td>" + checkBtn + " " + pencilBtn + " " + removeBtn
				+ "</td>";
		var tr = "<tr>" + numberTd + checkboxTd + roleNameTd + buttonTd
				+ "</tr>";
		$("#rolePageBody").append(tr);
	}
	generateNavigator(pageInfo);
}

// 生成分页页码导航条
function generateNavigator(pageInfo) {
	// 获取总记录数
	var totalRecord = pageInfo.total;
	// 声明相关属性
	var properties = {
		"num_edge_entries" : 3,
		"num_display_entries" : 5,
		"callback" : paginationCallBack,
		"items_per_page" : pageInfo.pageSize,
		"current_page" : pageInfo.pageNum - 1,
		"prev_text" : "上一页",
		"next_text" : "下一页"
	}
	$("#Pagination").pagination(totalRecord, properties);
}

// 翻页时的回调函数
function paginationCallBack(pageIndex, jQuery) {
	// 修改pageNum
	window.pageNum = pageIndex + 1;
	// 调用分页函数
	generatePage();
	// 取消页码超链接的默认行为
	return false;
}

// 显示确认模态框
function showConfirmModal(roleArray) {
	// 打开模态框
	$("#confirmModal").modal("show");
	// 清除旧数据
	$("#roleNameDiv").empty();
	// 创建数组存放角色id
	window.roleIdArray = [];
	// 遍历
	for (var i = 0; i < roleArray.length; i++) {
		var role = roleArray[i];
		var roleName = role.roleName;
		$("#roleNameDiv").append(roleName + "<br/>");
		var roleId = role.roleId;
		// 数组存入元素
		window.roleIdArray.push(roleId);
	}
}
