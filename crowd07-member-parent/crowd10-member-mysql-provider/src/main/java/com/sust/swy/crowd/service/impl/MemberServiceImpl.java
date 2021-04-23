package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.po.MemberPOExample;
import com.sust.swy.crowd.entity.po.MemberPOExample.Criteria;
import com.sust.swy.crowd.mapper.MemberPOMapper;
import com.sust.swy.crowd.service.api.MemberService;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberPOMapper memberPoMapper;

	@Override
	public MemberPO getMemberPOByLoginAcct(String loginacct) {
		MemberPOExample example = new MemberPOExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginacctEqualTo(loginacct);
		List<MemberPO> list = memberPoMapper.selectByExample(example);
		return list.get(0);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = false)
	@Override
	public void saveMember(MemberPO memberPO) {
		memberPoMapper.insertSelective(memberPO);
	}

}
