package com.sust.swy.print.mvc.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.service.api.MerchantService;

@Controller
public class MerchantHandler {

	@Autowired
	private MerchantService merchantService;
	
	@RequestMapping("/merchant/do/register.html")
	public String merchantDoRegister(@RequestParam("loginAcct") String loginAcct,
			@RequestParam("userpswd") String userpswd, @RequestParam("username") String username,
			@RequestParam("email") String email,@RequestParam("accountNum") String accountNum, HttpSession session) {
		String coding = PrintUtil.md5(userpswd);
		Merchant merchant = new Merchant();
		merchant.setLoginAcct(loginAcct);
		merchant.setLoginPswd(coding);
		merchant.setMerchantName(username);
		merchant.setMerchantEmail(email);
		merchant.setAccountNum(accountNum);
		merchantService.saveMerchant(merchant);
		session.setAttribute(PrintConstant.ATTR_NAME_MERCHANT, merchant);
		return "redirect:/to/merchant/login/page.html";
	}
	
	@RequestMapping("/merchant/loginout.html")
	public String merchantLoginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/to/merchant/login/page.html";
	}

	@RequestMapping("/merchant/do/login.html")
	public String merchantDoLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Merchant merchant = merchantService.getMerchantByLoginAcct(loginAcct, usePswd);
		session.setAttribute(PrintConstant.ATTR_NAME_MERCHANT, merchant);
		return "redirect:/to/merchant/main/page.html";
	}
	
}
