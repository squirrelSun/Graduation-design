package com.sust.swy.crowd.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Role;

public interface RoleService {

	PageInfo<Role> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	void saveRole(Role role);

	void updateRole(Role role);

	void removeRole(List<Integer> roleIdList);

	List<Role> getAssignedRole(Integer roleId);

	List<Role> getUnAssignedRole(Integer roleId);
	
}
