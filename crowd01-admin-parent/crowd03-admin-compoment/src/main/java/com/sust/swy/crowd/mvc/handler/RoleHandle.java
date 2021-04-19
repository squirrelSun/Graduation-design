package com.sust.swy.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Role;
import com.sust.swy.crowd.service.api.RoleService;
import com.sust.swy.crowd.util.ResultEntity;

@Controller
public class RoleHandle {

	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping("/role/get/page/info.json")
	public ResultEntity<PageInfo<Role>> getPageInfo(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageInfo<Role> pageInfo = roleService.getPageInfo(keyword, pageNum, pageSize);
		return ResultEntity.successWithData(pageInfo);
	}

	@ResponseBody
	@RequestMapping("/role/save.json")
	public ResultEntity<String> saveRole(Role role) {
		roleService.saveRole(role);
		return ResultEntity.successWithoutData();
	}

	@ResponseBody
	@RequestMapping("/role/update.json")
	public ResultEntity<String> updateRole(Role role) {
		roleService.updateRole(role);
		return ResultEntity.successWithoutData();
	}

	@ResponseBody
	@RequestMapping("/role/remove/by/role/id/array.json")
	public ResultEntity<String> removeByRoleIdAarry(@RequestBody List<Integer> roleIdList) {
		roleService.removeRole(roleIdList);
		return ResultEntity.successWithoutData();
	}
}
