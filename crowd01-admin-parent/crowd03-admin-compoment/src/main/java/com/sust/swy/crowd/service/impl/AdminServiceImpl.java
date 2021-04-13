package com.sust.swy.crowd.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Admin;
import com.sust.swy.crowd.entity.AdminExample;
import com.sust.swy.crowd.entity.AdminExample.Criteria;
import com.sust.swy.crowd.exception.LoginFailedException;
import com.sust.swy.crowd.mapper.AdminMapper;
import com.sust.swy.crowd.service.api.AdminService;
import com.sust.swy.crowd.util.CrowdUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public void saveAdmin(Admin admin) {
		adminMapper.insert(admin);
	}

	@Override
	public List<Admin> getAll() {
		return adminMapper.selectByExample(new AdminExample());
	}

	@Override
	public Admin getAdminByLoginAcct(String loginAcct, String usePswd) {
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		criteria.andLoginAcctEqualTo(loginAcct);
		List<Admin> list = adminMapper.selectByExample(adminExample);
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		if (list.size() > 1) {
			throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}
		Admin admin = list.get(0);
		if (admin == null) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		String userPswdDB = admin.getUserPswd();
		String userPaedFrom = CrowdUtil.md5(usePswd);
		if (!Objects.equals(userPswdDB, userPaedFrom)) {
			throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
		}
		return admin;
	}

}
