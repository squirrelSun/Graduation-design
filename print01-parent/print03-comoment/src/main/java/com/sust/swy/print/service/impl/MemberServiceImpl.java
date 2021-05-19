package com.sust.swy.print.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.exception.LoginFailedException;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.entity.Member;
import com.sust.swy.print.entity.MemberExample;
import com.sust.swy.print.entity.MemberExample.Criteria;
import com.sust.swy.print.mapper.MemberMapper;
import com.sust.swy.print.service.api.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public PageInfo<Member> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Member> list = memberMapper.selectMemberByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public void removeMemberById(Integer memberId) {
		Member member = memberMapper.selectByPrimaryKey(memberId);
		if (member.getIsDelete() == 1) {
			member.setIsDelete(0);
		} else if (member.getIsDelete() == 0) {
			member.setIsDelete(1);
		}
		memberMapper.updateByPrimaryKey(member);
	}

	@Override
	public void changeMemberById(Integer memberId) {
		Member member = memberMapper.selectByPrimaryKey(memberId);
		if (member.getMemberStatus() == 1) {
			member.setMemberStatus(0);
		} else if (member.getMemberStatus() == 0) {
			member.setMemberStatus(1);
		}
		memberMapper.updateByPrimaryKey(member);
	}

	@Override
	public Member getMemberByLoginAcct(String loginAcct, String usePswd) {
		MemberExample memberExample = new MemberExample();
		Criteria criteria = memberExample.createCriteria();
		criteria.andLoginAcctEqualTo(loginAcct);
		List<Member> list = memberMapper.selectByExample(memberExample);
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		if (list.size() > 1) {
			throw new RuntimeException(PrintConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}
		Member member = list.get(0);
		if (member == null) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		String userPswdDB = member.getLoginPswd();
		String userPaedFrom = PrintUtil.md5(usePswd);
		if (!Objects.equals(userPswdDB, userPaedFrom)) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		return member;
	}

	@Override
	public void saveMember(Member member) {
		memberMapper.insertSelective(member);
		
	}

}
