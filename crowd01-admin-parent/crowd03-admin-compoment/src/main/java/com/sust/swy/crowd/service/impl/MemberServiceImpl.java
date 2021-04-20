package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.Member;
import com.sust.swy.crowd.exception.LoginAcctAlreadyInUseForUpdateException;
import com.sust.swy.crowd.mapper.MemberMapper;
import com.sust.swy.crowd.service.api.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public PageInfo<Member> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Member> list = memberMapper.selectMemberByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public Member getMemberById(Integer memberId) {
		Member member = memberMapper.selectByPrimaryKey(memberId);
		return member;
	}

	@Override
	public void update(Member member) {
		try {
			memberMapper.updateByPrimaryKeySelective(member);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof DuplicateKeyException) {
				throw new LoginAcctAlreadyInUseForUpdateException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
			}
			throw e;
		}
	}

	@Override
	public void removeMemberById(Integer memberId) {
		memberMapper.deleteByPrimaryKey(memberId);
	}

}
