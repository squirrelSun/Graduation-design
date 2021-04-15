package com.sust.swy.crowd.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Admin;

public interface AdminService {

	void saveAdmin(Admin admin);

	List<Admin> getAll();

	Admin getAdminByLoginAcct(String loginAcct, String usePswd);

	PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	Admin getAdminById(Integer adminId);

	void removeAdminById(Integer adminId);

	void update(Admin admin);

}
