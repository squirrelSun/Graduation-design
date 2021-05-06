package com.sust.swy.crowd.handler;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sust.swy.crowd.api.MySQLRemoteService;
import com.sust.swy.crowd.api.RedisRemoteService;
import com.sust.swy.crowd.config.ShortMessageProperties;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.vo.MemberLoginVO;
import com.sust.swy.crowd.entity.vo.MemberVO;
import com.sust.swy.crowd.entity.vo.PortalProjectVO;
import com.sust.swy.crowd.util.CrowdUtil;
import com.sust.swy.crowd.util.ResultEntity;

@Controller
public class MemberHandler {

	@Autowired
	ShortMessageProperties shortMessageProperties;

	@Autowired
	RedisRemoteService redisRemoteService;

	@Autowired
	MySQLRemoteService mySQLRemoteService;

	@RequestMapping("/member/my/crowd")
	public String myCrowd(Model model, HttpSession session) {
		
		
		return "member-crowd";
	}
	
	@RequestMapping("/member/my/crowd/create")
	public String myCreate(Model model, HttpSession session) {
		MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
		Integer memberId = memberLoginVO.getId();
		ResultEntity<List<PortalProjectVO>> resultEntity = mySQLRemoteService.getProjectByMemberId(memberId);
		String result = resultEntity.getOperationResult();
		if (ResultEntity.SUCCESS.equals(result)) {
			List<PortalProjectVO> list = resultEntity.getQueryData();
			model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_MEMBER_DATA, list);
		}
		return "member-create";
	}

	@RequestMapping("/auth/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:http://localhost/";
	}

	@RequestMapping("/auth/member/do/login")
	public String login(@RequestParam("loginacct") String loginacct, @RequestParam("userpswd") String userpswd,
			ModelMap modelMap, HttpSession session) {
		ResultEntity<MemberPO> resultEntity = mySQLRemoteService.getMemberPOByLoginAcctRemote(loginacct);
		if (ResultEntity.FAILED.equals(resultEntity.getOperationResult())) {
			modelMap.put(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getOperationMessage());
			return "member-login";
		}
		MemberPO memberPO = resultEntity.getQueryData();
		if (memberPO == null) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
			return "member-login";
		}
		String userpswdDataBase = memberPO.getUserpswd();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean matcheResult = passwordEncoder.matches(userpswd, userpswdDataBase);
		if (!matcheResult) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_LOGIN_FAILED);
			return "member-login";
		}
		MemberLoginVO memberLoginVO = new MemberLoginVO(memberPO.getId(), memberPO.getUsername(), memberPO.getEmail(),
				memberPO.getAuthstatus());
		session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER, memberLoginVO);
		return "redirect:http://localhost/auth/member/to/center/page";
	}

	@RequestMapping("/auth/do/member/register")
	public String register(MemberVO memberVO, ModelMap modelMap) {
		String phoneNum = memberVO.getPhoneNum();
		String formCode = memberVO.getCode();
		String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
		ResultEntity<String> resultEntity = redisRemoteService.getRedisStringValueByKeyRemote(key);
		String result = resultEntity.getOperationResult();
		if (ResultEntity.FAILED.equals(result)) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, resultEntity.getOperationMessage());
			return "member-reg";
		}
		String redisCode = resultEntity.getQueryData();
		if (redisCode == null && !CrowdConstant.TOKEN_CODE.equals(formCode)) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_NOT_EXISTS);
			return "member-reg";
		}
		if (!Objects.equals(formCode, redisCode) && !CrowdConstant.TOKEN_CODE.equals(formCode)) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_CODE_INVALID);
			return "member-reg";
		}
		if (!CrowdConstant.TOKEN_CODE.equals(formCode)) {
			redisRemoteService.removeRedisKeyRemote(key);
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String userpswd = memberVO.getUserpswd();
		String encode = passwordEncoder.encode(userpswd);
		memberVO.setUserpswd(encode);
		MemberPO memberPO = new MemberPO();
		BeanUtils.copyProperties(memberVO, memberPO);
		ResultEntity<String> saveMemeberResultEntity = mySQLRemoteService.saveMeneber(memberPO);
		if (ResultEntity.FAILED.equals(saveMemeberResultEntity.getOperationResult())) {
			modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveMemeberResultEntity.getOperationMessage());
			return "member-reg";
		}
		return "redirect:http://localhost/auth/member/to/login/page";
	}

	@ResponseBody
	@RequestMapping("auth/member/send/short/message.json")
	public ResultEntity<String> sendMesssage(@RequestParam("phoneNum") String phoneNum) {
		ResultEntity<String> sendMessageResultEntity = CrowdUtil.sendCodeByShortMessage(
				shortMessageProperties.getHost(), shortMessageProperties.getPath(), shortMessageProperties.getMethod(),
				phoneNum, shortMessageProperties.getAppcode(), shortMessageProperties.getSign(),
				shortMessageProperties.getSkin());
		if (ResultEntity.SUCCESS.equals(sendMessageResultEntity.getQueryData())) {
			String code = sendMessageResultEntity.getQueryData();
			String key = CrowdConstant.REDIS_CODE_PREFIX + phoneNum;
			long time = 15;
			TimeUnit timeUnit = TimeUnit.MINUTES;
			ResultEntity<String> saveCodeResultEntity = redisRemoteService.setRedisKeyValueRemoteWithTimeout(key, code,
					time, timeUnit);
			if (ResultEntity.SUCCESS.equals(saveCodeResultEntity.getOperationResult())) {
				return ResultEntity.successWithoutData();
			} else {
				return saveCodeResultEntity;
			}
		} else {
			return sendMessageResultEntity;
		}
	}

}
