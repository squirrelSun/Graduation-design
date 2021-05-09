package com.sust.swy.crowd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Member;
import com.sust.swy.crowd.entity.MemberCerticficatInfo;
import com.sust.swy.crowd.entity.MemberCerticficatInfoDetail;
import com.sust.swy.crowd.entity.Project;
import com.sust.swy.crowd.mapper.MemberCerticficatInfoMapper;
import com.sust.swy.crowd.mapper.MemberMapper;
import com.sust.swy.crowd.mapper.ProjectMapper;
import com.sust.swy.crowd.service.api.CheckService;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private MemberCerticficatInfoMapper memberCerticficatInfoMapper;

	@Override
	public PageInfo<MemberCerticficatInfoDetail> getPageInfoMember(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MemberCerticficatInfo> list = memberCerticficatInfoMapper.selectMemberCerticficatInfoByKeyword(keyword);
		List<MemberCerticficatInfoDetail> res = new ArrayList<>();
		for (MemberCerticficatInfo certicficat : list) {
			MemberCerticficatInfoDetail detail = new MemberCerticficatInfoDetail();
			Integer memberid = certicficat.getMemberid();
			Member member = memberMapper.selectByPrimaryKey(memberid);
			detail.setCerticficatId(String.valueOf(certicficat.getId()));
			detail.setMemberId(String.valueOf(memberid));
			detail.setRealName(certicficat.getRealname());
			detail.setCardnum(certicficat.getCardnum());
			detail.setPhone(certicficat.getPhone());
			detail.setPhotoHand(certicficat.getPhotoHand());
			detail.setPhotoOn(certicficat.getPhotoOn());
			detail.setPhotoOff(certicficat.getPhotoOff());
			detail.setLoginacct(member.getLoginacct());
			detail.setUsername(member.getUsername());
			detail.setEmail(member.getEmail());
			detail.setAuthstatus(String.valueOf(member.getAuthstatus()));
			res.add(detail);
		}
		PageInfo<MemberCerticficatInfoDetail> pageInfo = new PageInfo<>();
		pageInfo.setList(res);
		return pageInfo;
	}

	@Override
	public void updataMemberCertificatById(Integer memberId, Integer certicficatId) {
		MemberCerticficatInfo certicficat = memberCerticficatInfoMapper.selectByPrimaryKey(certicficatId);
		Member member = memberMapper.selectByPrimaryKey(memberId);
		member.setAuthstatus(2);
		member.setRealname(certicficat.getRealname());
		member.setCardnum(certicficat.getCardnum());
		memberMapper.updateByPrimaryKey(member);
	}

	@Override
	public void removeMemberCertificatById(Integer memberId, Integer certicficatId) {
		Member member = memberMapper.selectByPrimaryKey(memberId);
		member.setAuthstatus(0);
		memberMapper.updateByPrimaryKey(member);
		memberCerticficatInfoMapper.deleteByPrimaryKey(certicficatId);
	}

	@Override
	public PageInfo<Project> getPageInfoProject(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Project> list = projectMapper.selectProjectByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public void removeProjectById(Integer projectId) {
		projectMapper.deleteByPrimaryKey(projectId);
	}

	@Override
	public void agreeProjectById(Integer projectId) {
		Project project = projectMapper.selectByPrimaryKey(projectId);
		project.setStatus(1);
		projectMapper.updateByPrimaryKey(project);
	}

	@Override
	public void successProjectById(Integer projectId) {
		Project project = projectMapper.selectByPrimaryKey(projectId);
		project.setStatus(2);
		projectMapper.updateByPrimaryKey(project);
	}

	@Override
	public void failProjectById(Integer projectId) {
		Project project = projectMapper.selectByPrimaryKey(projectId);
		project.setStatus(3);
		projectMapper.updateByPrimaryKey(project);
	}

}
