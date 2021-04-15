package com.sust.swy.crowd.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Admin;
import com.sust.swy.crowd.service.api.AdminService;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;

	// 删除
	@RequestMapping("admin/remove/{adminId}/{pageNum}/{keyword}.html")
	public String remove(@PathVariable("adminId") Integer adminId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		adminService.removeAdminById(adminId);
		return "redirect:/admin/get/page.html?pageNum=" + pageNum;
	}

	// 修改
	@RequestMapping("/admin/to/edit/page.html")
	public String toEditPage(@RequestParam("adminId") Integer adminId, ModelMap modelMap) {
		Admin admin = adminService.getAdminById(adminId);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_ADMIN, admin);
		return "admin-edit";
	}

	@RequestMapping("/admin/update.html")
	public String update(Admin admin, @RequestParam("keyword") String keyword,
			@RequestParam("pageNum") Integer pageNum) {
		adminService.update(admin);
		return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
	}

	// 新增
	@RequestMapping("/admin/save.html")
	public String save(Admin admin) {
		adminService.saveAdmin(admin);
		return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
	}

	// 分页查询显示
	@RequestMapping("/admin/get/page.html")
	public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, ModelMap modelMap) {
		PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "admin-page";
	}

	// 登出
	@RequestMapping("secrity/do/logout.html")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/to/login/page.html";
	}

	// 登录
	@RequestMapping("/admin/do/login.html")
	public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Admin admin = adminService.getAdminByLoginAcct(loginAcct, usePswd);
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
		return "redirect:/admin/to/main/page.html";
	}

}
