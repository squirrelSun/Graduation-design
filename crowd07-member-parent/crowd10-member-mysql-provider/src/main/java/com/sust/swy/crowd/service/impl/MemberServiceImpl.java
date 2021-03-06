package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sust.swy.crowd.entity.po.MemberCerticficatInfoPO;
import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.po.MemberPOExample;
import com.sust.swy.crowd.entity.po.MemberPOExample.Criteria;
import com.sust.swy.crowd.mapper.MemberCerticficatInfoPOMapper;
import com.sust.swy.crowd.mapper.MemberPOMapper;
import com.sust.swy.crowd.service.api.MemberService;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberPOMapper memberPoMapper;

	@Autowired
	private MemberCerticficatInfoPOMapper memberCerticficatInfoPOMapper;

	@Override
	public MemberPO getMemberPOByLoginAcct(String loginacct) {
		MemberPOExample example = new MemberPOExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginacctEqualTo(loginacct);
		List<MemberPO> list = memberPoMapper.selectByExample(example);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = false)
	@Override
	public void saveMember(MemberPO memberPO) {
		memberPoMapper.insertSelective(memberPO);
	}

	@Override
	public MemberPO getMemberPOByMemberid(String memberId) {
		MemberPOExample example = new MemberPOExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(Integer.valueOf(memberId));
		List<MemberPO> list = memberPoMapper.selectByExample(example);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = false)
	@Override
	public void insertMeneberCerticficatInfo(MemberCerticficatInfoPO memberCerticficatInfoPO) {
		memberCerticficatInfoPOMapper.insert(memberCerticficatInfoPO);
		Integer memberid = memberCerticficatInfoPO.getMemberid();
		MemberPO memberPO = memberPoMapper.selectByPrimaryKey(memberid);
		memberPO.setAuthstatus(1);
		memberPoMapper.updateByPrimaryKey(memberPO);
	}

}
