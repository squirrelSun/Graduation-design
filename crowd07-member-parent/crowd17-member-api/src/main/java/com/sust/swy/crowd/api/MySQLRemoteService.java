package com.sust.swy.crowd.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.util.ResultEntity;

@FeignClient("sust-swy-crowd-mysql")
public interface MySQLRemoteService {

	@RequestMapping("/get/memberpo/by/login/acct/remote")
	ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

}
