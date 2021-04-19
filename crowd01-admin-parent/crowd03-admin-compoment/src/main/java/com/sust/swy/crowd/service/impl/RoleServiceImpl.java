package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.RoleExample.Criteria;
import com.sust.swy.crowd.entity.Role;
import com.sust.swy.crowd.entity.RoleExample;
import com.sust.swy.crowd.mapper.RoleMapper;
import com.sust.swy.crowd.service.api.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public PageInfo<Role> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Role> list = roleMapper.selectRoleByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public void saveRole(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public void removeRole(List<Integer> roleIdList) {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(roleIdList);
		roleMapper.deleteByExample(example);
	}

	@Override
	public List<Role> getAssignedRole(Integer adminId) {

		return roleMapper.selectAssignedRole(adminId);
	}

	@Override
	public List<Role> getUnAssignedRole(Integer adminId) {
		return roleMapper.selectUnAssignedRole(adminId);
	}

}
