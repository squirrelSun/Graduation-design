package com.sust.swy.print.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Member;

public interface MemberService {

	PageInfo<Member> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	void removeMemberById(Integer memberId);

	void changeMemberById(Integer memberId);

	Member getMemberByLoginAcct(String loginAcct, String usePswd);

	void saveMember(Member member);


}
