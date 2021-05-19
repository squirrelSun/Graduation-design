package com.sust.swy.print.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.entity.Document;
import com.sust.swy.print.entity.Member;
import com.sust.swy.print.entity.Order;
import com.sust.swy.print.service.api.DocumentService;
import com.sust.swy.print.service.api.MemberService;
import com.sust.swy.print.service.api.OrderService;

@Controller
public class MemberHandler {

	@Autowired
	private MemberService memberService;

	@Autowired
	private DocumentService documentService;

	@Autowired
	private OrderService orderService;

	@RequestMapping("/member/do/register.html")
	public String memberDoRegister(@RequestParam("loginAcct") String loginAcct,
			@RequestParam("userpswd") String userpswd, @RequestParam("username") String username,
			@RequestParam("email") String email, HttpSession session) {
		String coding = PrintUtil.md5(userpswd);
		Member member = new Member();
		member.setLoginAcct(loginAcct);
		member.setLoginPswd(coding);
		member.setMemberName(username);
		member.setMemberEmail(email);
		memberService.saveMember(member);
		session.setAttribute(PrintConstant.ATTR_NAME_MEMBER, member);
		return "redirect:/to/member/login/page.html";
	}

	@RequestMapping("/member/loginout.html")
	public String memberLoginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/to/member/login/page.html";
	}

	@RequestMapping("/member/do/login.html")
	public String memberDoLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Member member = memberService.getMemberByLoginAcct(loginAcct, usePswd);
		Integer memberId = member.getId();
		List<Document> documentlist = documentService.getDocumentListByMemberId(memberId);
		List<Order> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_MEMBER, member);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/member/main/page.html";
	}

}
