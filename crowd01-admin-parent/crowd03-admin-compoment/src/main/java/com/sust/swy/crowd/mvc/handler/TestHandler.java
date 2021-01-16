package com.sust.swy.crowd.mvc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sust.swy.crowd.entity.Admin;
import com.sust.swy.crowd.service.api.AdminService;

@Controller
public class TestHandler {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/test/ssm.html")
	public String TestSsm(ModelMap map) {
		List<Admin> adminList = adminService.getAll();
		map.addAttribute("adminList", adminList);
//		System.out.println(10 / 0);
		return "target";
	}
	
}
