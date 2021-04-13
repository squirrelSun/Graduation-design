package com.sust.swy.crowd.service.api;

import java.util.List;

import com.sust.swy.crowd.entity.Admin;

public interface AdminService {

	void saveAdmin(Admin admin);

	List<Admin> getAll();

	Admin getAdminByLoginAcct(String loginAcct, String usePswd);
	
}
