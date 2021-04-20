package com.sust.swy.crowd.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Member;
import com.sust.swy.crowd.service.api.MemberService;

@Controller
public class MemberHandler {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/member/remove/{memberId}/{pageNum}/{keyword}.html")
	public String remove(@PathVariable("memberId") Integer memberId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		memberService.removeMemberById(memberId);
		return "redirect:/member/get/page.html?pageNum=" + pageNum;
	}

	@RequestMapping("/member/update.html")
	public String update(Member member, @RequestParam("keyword") String keyword,
			@RequestParam("pageNum") Integer pageNum) {
		memberService.update(member);
		return "redirect:/member/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
	}

	@RequestMapping("member/to/edit/page.html")
	public String toEditPage(@RequestParam("memberId") Integer memberId, ModelMap modelMap) {
		Member member = memberService.getMemberById(memberId);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_MEMBER, member);
		return "member-edit";
	}

	@RequestMapping("/member/get/page.html")
	public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, ModelMap modelMap) {
		PageInfo<Member> pageInfo = memberService.getPageInfo(keyword, pageNum, pageSize);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "member-page";
	}

}
