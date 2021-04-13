package com.sust.swy.crowd.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Admin;
import com.sust.swy.crowd.service.api.AdminService;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;

	@RequestMapping("secrity/do/logout.html")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/to/login/page.html";
	}
	
	@RequestMapping("/admin/do/login.html")
	public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Admin admin = adminService.getAdminByLoginAcct(loginAcct, usePswd);
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
		return "redirect:/admin/to/main/page.html";
	}

}
