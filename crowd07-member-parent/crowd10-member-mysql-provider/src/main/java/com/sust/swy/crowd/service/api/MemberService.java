package com.sust.swy.crowd.service.api;

import com.sust.swy.crowd.entity.po.MemberCerticficatInfoPO;
import com.sust.swy.crowd.entity.po.MemberPO;

public interface MemberService {

	MemberPO getMemberPOByLoginAcct(String loginacct);

	void saveMember(MemberPO memberPO);

	MemberPO getMemberPOByMemberid(String memberId);

	void insertMeneberCerticficatInfo(MemberCerticficatInfoPO memberCerticficatInfoPO);

}
