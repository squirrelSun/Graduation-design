package com.sust.swy.print.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.entity.Admin;
import com.sust.swy.print.entity.MachineWithMerchant;
import com.sust.swy.print.entity.Member;
import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.entity.OrderDetail;
import com.sust.swy.print.service.api.AdminService;
import com.sust.swy.print.service.api.MachineService;
import com.sust.swy.print.service.api.MemberService;
import com.sust.swy.print.service.api.MerchantService;
import com.sust.swy.print.service.api.OrderService;

@Controller
public class AdminHandler {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private MachineService machineService;
	
	@Autowired
	private OrderService orderService;

	
	
	@RequestMapping("/member/get/page.html")
	public String getMemberPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, ModelMap modelMap) {
		PageInfo<Member> pageInfo = memberService.getPageInfoForAdmin(keyword, pageNum, pageSize);
		modelMap.addAttribute(PrintConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "admin-member-page";
	}
	
	@RequestMapping("/member/change/{memberId}/{pageNum}/{keyword}.html")
	public String changeMemberFromAdmin(@PathVariable("memberId") Integer memberId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		memberService.changeMemberById(memberId);
		return "redirect:/member/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/member/remove/{memberId}/{pageNum}/{keyword}.html")
	public String removeMemberFromAdmin(@PathVariable("memberId") Integer memberId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		memberService.removeMemberById(memberId);
		return "redirect:/member/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/merchant/get/page.html")
	public String getMerchantPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, ModelMap modelMap) {
		PageInfo<Merchant> pageInfo = merchantService.getPageInfoForAdmin(keyword, pageNum, pageSize);
		modelMap.addAttribute(PrintConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "admin-merchant-page";
	}
	
	@RequestMapping("/merchant/change/{merchantId}/{pageNum}/{keyword}.html")
	public String changeMerchantFromAdmin(@PathVariable("merchantId") Integer merchantId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		merchantService.changeMerchantById(merchantId);
		return "redirect:/merchant/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/merchant/remove/{merchantId}/{pageNum}/{keyword}.html")
	public String removeMerchantFromAdmin(@PathVariable("merchantId") Integer merchantId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		merchantService.removeMerchantById(merchantId);
		return "redirect:/merchant/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/machine/get/page.html")
	public String getMachinePageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, ModelMap modelMap) {
		PageInfo<MachineWithMerchant> pageInfo = machineService.getPageInfoForAdmin(keyword, pageNum, pageSize);
		modelMap.addAttribute(PrintConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "admin-machine-page";
	}
	
	@RequestMapping("/machine/change/{machineId}/{pageNum}/{keyword}.html")
	public String changeMachineFromAdmin(@PathVariable("machineId") Integer machineId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		machineService.changeMachineById(machineId);
		return "redirect:/machine/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/machine/remove/{machineId}/{pageNum}/{keyword}.html")
	public String removeMachineFromAdmin(@PathVariable("machineId") Integer machineId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		machineService.removeMachineById(machineId);
		return "redirect:/machine/get/page.html?pageNum=" + pageNum;
	}
	
	@RequestMapping("/order/get/page.html")
	public String getOrderPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, ModelMap modelMap) {
		PageInfo<OrderDetail> pageInfo = orderService.getPageInfoForAdmin(keyword, pageNum, pageSize);
		modelMap.addAttribute(PrintConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "admin-order-page";
	}
	
	@RequestMapping("/admin/loginout.html")
	public String adminLoginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/to/admin/login/page.html";
	}

	@RequestMapping("/admin/do/login.html")
	public String adminDoLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Admin admin = adminService.getAdminByLoginAcct(loginAcct, usePswd);
		session.setAttribute(PrintConstant.ATTR_NAME_ADMIN, admin);
		return "redirect:/to/admin/main/page.html";
	}

}
