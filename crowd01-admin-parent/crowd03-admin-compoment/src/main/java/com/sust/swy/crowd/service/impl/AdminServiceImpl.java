package com.sust.swy.crowd.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Admin;
import com.sust.swy.crowd.entity.AdminExample;
import com.sust.swy.crowd.entity.AdminExample.Criteria;
import com.sust.swy.crowd.exception.LoginAcctAlreadyInUseException;
import com.sust.swy.crowd.exception.LoginAcctAlreadyInUseForUpdateException;
import com.sust.swy.crowd.exception.LoginFailedException;
import com.sust.swy.crowd.mapper.AdminMapper;
import com.sust.swy.crowd.service.api.AdminService;
import com.sust.swy.crowd.util.CrowdUtil;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<Admin> getAll() {
		return adminMapper.selectByExample(new AdminExample());
	}

	@Override
	public void saveAdmin(Admin admin) {
		Date data = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String creatTime = dateFormat.format(data);
		String source = admin.getUserPswd();
		String encoded = CrowdUtil.md5(source);
		admin.setUserPswd(encoded);
		admin.setCreateTime(creatTime);
		try {
			adminMapper.insert(admin);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
			throw e;
		}

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

	@Override
	public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Admin> list = adminMapper.selectAdminByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		Admin admin = adminMapper.selectByPrimaryKey(adminId);
		return admin;
	}

	@Override
	public void removeAdminById(Integer adminId) {
		adminMapper.deleteByPrimaryKey(adminId);
	}

	@Override
	public void update(Admin admin) {
		try {
			adminMapper.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseForUpdateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
			throw e;
		}
	}

}
