package com.sust.swy.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Member;

public interface MemberService {

	PageInfo<Member> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	Member getMemberById(Integer memberId);

	void update(Member member);

	void removeMemberById(Integer memberId);

}
