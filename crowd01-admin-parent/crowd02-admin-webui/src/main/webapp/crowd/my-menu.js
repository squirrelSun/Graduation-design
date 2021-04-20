// 生成树形结构函数
function generateTree() {
	console.log("b")
	// ajax请求得到数据
	$.ajax({
		"url" : "menu/get/whole/tree.json",
		"type" : "post",
		"dataType" : "json",
		"success" : function(response) {
			var result = response.operationResult;
			if (result == "SUCCESS") {
				// 创建 JSON 存储 zTree 设置
				var setting = {
					"view" : {
						"addDiyDom" : myAddDiyDom,
						"addHoverDom" : myAddHoverDom,
						"removeHoverDom" : myRemoveHoverDom
					},
					"data" : {
						"key" : {
							// 取消跳转
							"url" : "squirrel"
						}
					}
				};
				// 获取 JSON 数据
				var zNodes = response.queryData;
				// 初始化树形结构
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			}
			if (result == "FAILED") {
				layer.msg(response.operationMessage);
			}
		}
	});
}

// 修改默认图标
function myAddDiyDom(treeId, treeNode) {
	// 整个树形结构附着的ul标签的id
	console.log("treeId=" + treeId);
	// 当前树形节点的数据
	console.log(treeNode);
	var spanId = treeNode.tId + "_ico";
	$("#" + spanId).removeClass().addClass(treeNode.icon);
}

// 移入节点范围添加按钮组
function myAddHoverDom(treeId, treeNode) {
	// 给span设置规律的id
	var btnGroupId = treeNode.tId + "_btnGrp";
	// 判断一下是否已添加了按钮组
	if ($("#" + btnGroupId).length > 0) {
		return;
	}
	// 准备HTML标签
	var addBtn = "<a id='"
			+ treeNode.id
			+ "' class='addBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='添加子节点'>&nbsp;&nbsp;<i class='fa fa-fw fa-plus rbg '></i></a>";
	var removeBtn = "<a id='"
			+ treeNode.id
			+ "' class='removeBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='删除节点'>&nbsp;&nbsp;<i class='fa fa-fw fa-times rbg '></i></a>";
	var editBtn = "<a id='"
			+ treeNode.id
			+ "' class='editBtn btn btn-info dropdown-toggle btn-xs' style='margin-left:10px;padding-top:0px;' href='#' title='修改节点'>&nbsp;&nbsp;<i class='fa fa-fw fa-edit rbg '></i></a>";
	// 获取当前节点的级别数据
	var level = treeNode.level;
	// 存储拼装好的按钮代码
	var btnHTML = "";
	// 判断当前节点的级别
	if (level == 0) {
		// 根节点，只能添加子节点
		btnHTML = addBtn;
	}
	if (level == 1) {
		// 分支节点，可以添加子节点、修改
		btnHTML = addBtn + " " + editBtn;
		// 获取当前节点的子节点数量
		var length = treeNode.children.length;
		// 没有子节点，可以删除
		if (length == 0) {
			btnHTML = btnHTML + " " + removeBtn;
		}
	}
	if (level == 2) {
		// 叶子节点，可以修改、删除
		btnHTML = editBtn + " " + removeBtn;
	}
	// 找到附着按钮组的超链接
	var anchorId = treeNode.tId + "_a";
	// 执行在超链接后面附加span元素的操作
	$("#" + anchorId).after(
			"<span id='" + btnGroupId + "'>" + btnHTML + "</span>");
}

// 离开节点范围删除按钮组
function myRemoveHoverDom(treeId, treeNode) {
	// 拼接按钮组的id
	var btnGroupId = treeNode.tId + "_btnGrp";
	// 移除对应元素
	$("#" + btnGroupId).remove();
}