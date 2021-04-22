package com.sust.swy.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.service.api.MemberService;
import com.sust.swy.crowd.util.ResultEntity;

@RestController
public class MemberProviderHandler {

	@Autowired
	MemberService memberService;

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
