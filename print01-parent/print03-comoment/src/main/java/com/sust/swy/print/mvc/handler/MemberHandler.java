package com.sust.swy.print.mvc.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.constant.util.ResultEntity;
import com.sust.swy.print.entity.Document;
import com.sust.swy.print.entity.Member;
import com.sust.swy.print.entity.OrderDetail;
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

	@ResponseBody
	@RequestMapping("/document/create/upload.json")
	public ResultEntity<String> uploadFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IOException {
		ResultEntity<String> uploadFileResultEntity = PrintUtil.uploadFileToOss(PrintConstant.OSS_END_POINT,
				PrintConstant.OSS_ACCESS_KEY_ID, PrintConstant.OSS_ACCESS_KEY_SECRET, file.getInputStream(),
				PrintConstant.OSS_BUCKET_NAME, PrintConstant.OSS_BUCKET_DOMAIN, file.getOriginalFilename());
		Member member = (Member) session.getAttribute(PrintConstant.ATTR_NAME_MEMBER);
		Integer memberId = member.getId();
		documentService.creatDocument(name, file.getSize(), uploadFileResultEntity.getQueryData(), memberId);
		List<Document> documentlist = documentService.getDocumentListByMemberId(memberId);
		List<OrderDetail> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return uploadFileResultEntity;
	}

	@RequestMapping("/order/pay/{orderId}.html")
	public String OrderPay(@PathVariable("orderId") Integer orderId, HttpSession session) {
		Member member = (Member) session.getAttribute(PrintConstant.ATTR_NAME_MEMBER);
		Integer memberId = member.getId();
		orderService.payOrderByOrderId(orderId);
		List<Document> documentlist = documentService.getDocumentListByMemberId(memberId);
		List<OrderDetail> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/member/main/page.html";
	}

	@RequestMapping("/document/print/{documentId}.html")
	public String documentPrint(@PathVariable("documentId") Integer documentId, HttpSession session) {
		Member member = (Member) session.getAttribute(PrintConstant.ATTR_NAME_MEMBER);
		Integer memberId = member.getId();
		orderService.creatOrderForPay(documentId, memberId);
		List<Document> documentlist = documentService.getDocumentListByMemberId(memberId);
		List<OrderDetail> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/member/main/page.html";
	}

	@RequestMapping("/document/remove/{documentId}.html")
	public String documentRemove(@PathVariable("documentId") String documentId, HttpSession session) {
		Member member = (Member) session.getAttribute(PrintConstant.ATTR_NAME_MEMBER);
		Integer memberId = member.getId();
		documentService.deleteDocumentById(Integer.valueOf(documentId));
		List<Document> documentlist = documentService.getDocumentListByMemberId(memberId);
		List<OrderDetail> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/member/main/page.html";
	}

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
		List<OrderDetail> orderlist = orderService.getOrderListByMemberId(memberId);
		session.setAttribute(PrintConstant.ATTR_NAME_MEMBER, member);
		session.setAttribute(PrintConstant.ATTR_NAME_DOCUMENT, documentlist);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/member/main/page.html";
	}

}
