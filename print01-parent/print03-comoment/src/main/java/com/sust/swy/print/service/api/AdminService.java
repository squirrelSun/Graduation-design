package com.sust.swy.print.service.api;

import com.sust.swy.print.entity.Admin;

public interface AdminService {

	Admin getAdminByLoginAcct(String loginAcct, String usePswd);

}
