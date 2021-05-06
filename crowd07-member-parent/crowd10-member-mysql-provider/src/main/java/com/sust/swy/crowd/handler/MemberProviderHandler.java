package com.sust.swy.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.service.api.MemberService;
import com.sust.swy.crowd.util.ResultEntity;

@RestController
public class MemberProviderHandler {

	@Autowired
	MemberService memberService;

	@RequestMapping("/get/memberpo/by/memeber/id")
	public ResultEntity<MemberPO> getMemberPOByMemberid(@RequestParam("memberId") String memberId){
		try {
			MemberPO memberPO = memberService.getMemberPOByMemberid(memberId);
			return ResultEntity.successWithData(memberPO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}
	
	@RequestMapping("/save/memeber/remote")
	public ResultEntity<String> saveMeneber(@RequestBody MemberPO memberPO) {
		try {
			memberService.saveMember(memberPO);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				return ResultEntity.failed(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/get/memberpo/by/login/acct/remote")
	public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
		try {
			MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
			return ResultEntity.successWithData(memberPO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

}
