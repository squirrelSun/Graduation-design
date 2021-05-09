package com.sust.swy.crowd.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Project;
import com.sust.swy.crowd.entity.MemberCerticficatInfoDetail;
import com.sust.swy.crowd.service.api.CheckService;

@Controller
public class CheckHandler {

	@Autowired
	private CheckService checkService;

	@RequestMapping("/member/check/success/{memberId}/{certicficatId}/{pageNum}/{keyword}.html")
	public String agreeMember(@PathVariable("memberId") Integer memberId,
			@PathVariable("certicficatId") Integer certicficatId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.updataMemberCertificatById(memberId,certicficatId);
		return "redirect:/member/to/check.html?pageNum=" + pageNum;
	}

	@RequestMapping("/member/check/fail/{memberId}/{certicficatId}/{pageNum}/{keyword}.html")
	public String removeMember(@PathVariable("memberId") Integer memberId,
			@PathVariable("certicficatId") Integer certicficatId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.removeMemberCertificatById(memberId,certicficatId);
		return "redirect:/member/to/check.html?pageNum=" + pageNum;
	}

	@RequestMapping("/member/to/check.html")
	public String getMemberPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, ModelMap modelMap) {
		PageInfo<MemberCerticficatInfoDetail> pageInfo = checkService.getPageInfoMember(keyword, pageNum, pageSize);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "check-member";
	}

	@RequestMapping("/project/to/check.html")
	public String getProjectPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize, ModelMap modelMap) {
		PageInfo<Project> pageInfo = checkService.getPageInfoProject(keyword, pageNum, pageSize);
		modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
		return "check-project";
	}

	@RequestMapping("/project/remove/{projectId}/{pageNum}/{keyword}.html")
	public String removeProject(@PathVariable("projectId") Integer projectId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.removeProjectById(projectId);
		return "redirect:/project/to/check.html?pageNum=" + pageNum;
	}

	@RequestMapping("/project/agree/{projectId}/{pageNum}/{keyword}.html")
	public String agreeProject(@PathVariable("projectId") Integer projectId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.agreeProjectById(projectId);
		return "redirect:/project/to/check.html?pageNum=" + pageNum;
	}

	@RequestMapping("/project/success/{projectId}/{pageNum}/{keyword}.html")
	public String successProject(@PathVariable("projectId") Integer projectId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.successProjectById(projectId);
		return "redirect:/project/to/check.html?pageNum=" + pageNum;
	}

	@RequestMapping("/project/fail/{projectId}/{pageNum}/{keyword}.html")
	public String failProject(@PathVariable("projectId") Integer projectId, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("keyword") String keyword) {
		checkService.failProjectById(projectId);
		return "redirect:/project/to/check.html?pageNum=" + pageNum;
	}

}
