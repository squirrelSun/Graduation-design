package com.sust.swy.print.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.exception.LoginFailedException;
import com.sust.swy.print.entity.Admin;
import com.sust.swy.print.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public Admin getAdminByLoginAcct(String loginAcct, String usePswd) {
		if (Objects.equals(loginAcct, PrintConstant.TOKEN_ADMIN_USERNAME) && Objects.equals(usePswd, PrintConstant.TOKEN_ADMIN_PASSWORD)) {
			Admin admin = new Admin(0, loginAcct, usePswd, "root", "sunwwyy@163.com", null);
			return admin;
		}else {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
	}

}
