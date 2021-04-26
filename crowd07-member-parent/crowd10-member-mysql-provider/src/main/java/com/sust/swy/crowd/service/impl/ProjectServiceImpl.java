package com.sust.swy.crowd.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sust.swy.crowd.entity.po.MemberConfirmInfoPO;
import com.sust.swy.crowd.entity.po.MemberLaunchInfoPO;
import com.sust.swy.crowd.entity.po.ProjectPO;
import com.sust.swy.crowd.entity.po.ReturnPO;
import com.sust.swy.crowd.entity.vo.MemberConfirmInfoVO;
import com.sust.swy.crowd.entity.vo.MemberLauchInfoVO;
import com.sust.swy.crowd.entity.vo.ProjectVO;
import com.sust.swy.crowd.entity.vo.ReturnVO;
import com.sust.swy.crowd.mapper.MemberConfirmInfoPOMapper;
import com.sust.swy.crowd.mapper.MemberLaunchInfoPOMapper;
import com.sust.swy.crowd.mapper.ProjectItemPicPOMapper;
import com.sust.swy.crowd.mapper.ProjectPOMapper;
import com.sust.swy.crowd.mapper.ReturnPOMapper;
import com.sust.swy.crowd.service.api.ProjectService;

@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ReturnPOMapper returnPOMapper;

	@Autowired
	private MemberConfirmInfoPOMapper memberConfirmInfoPOMapper;

	@Autowired
	private MemberLaunchInfoPOMapper memberLaunchInfoPOMapper;

	@Autowired
	private ProjectPOMapper projectPOMapper;

	@Autowired
	private ProjectItemPicPOMapper projectItemPicPOMapper;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void saveProject(ProjectVO projectVO, Integer memberId) {
		ProjectPO projectPO = new ProjectPO();
		BeanUtils.copyProperties(projectVO, projectPO);
		projectPO.setMemberid(memberId);
		String createdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		projectPO.setCreatedate(createdate);
		projectPO.setStatus(0);
		projectPOMapper.insertSelective(projectPO);
		Integer projectId = projectPO.getId();
		List<Integer> typeIdList = projectVO.getTypeIdList();
		projectPOMapper.insertTypeRelationship(typeIdList, projectId);
		List<Integer> tagIdList = projectVO.getTagIdList();
		projectPOMapper.insertTagRelationship(tagIdList, projectId);
		List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
		projectItemPicPOMapper.insertPathList(projectId, detailPicturePathList);
		MemberLauchInfoVO memberLauchInfoVO = projectVO.getMemberLauchInfoVO();
		MemberLaunchInfoPO memberLaunchInfoPO = new MemberLaunchInfoPO();
		BeanUtils.copyProperties(memberLauchInfoVO, memberLaunchInfoPO);
		memberLaunchInfoPO.setMemberid(memberId);
		memberLaunchInfoPOMapper.insert(memberLaunchInfoPO);
		List<ReturnVO> returnVOList = projectVO.getReturnVOList();
		List<ReturnPO> returnPOList = new ArrayList<>();
		for (ReturnVO returnVO : returnVOList) {
			ReturnPO returnPO = new ReturnPO();
			BeanUtils.copyProperties(returnVO, returnPO);
			returnPOList.add(returnPO);
		}
		returnPOMapper.insertReturnPOBatch(returnPOList, projectId);
		MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
		MemberConfirmInfoPO memberConfirmInfoPO = new MemberConfirmInfoPO();
		BeanUtils.copyProperties(memberConfirmInfoVO, memberConfirmInfoPO);
		memberConfirmInfoPO.setMemberid(memberId);
		memberConfirmInfoPOMapper.insert(memberConfirmInfoPO);
	}

}
