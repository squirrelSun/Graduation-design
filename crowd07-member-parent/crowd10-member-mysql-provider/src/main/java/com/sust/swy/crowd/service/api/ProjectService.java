package com.sust.swy.crowd.service.api;

import java.util.List;

import com.sust.swy.crowd.entity.vo.DetailProjectVO;
import com.sust.swy.crowd.entity.vo.PortalProjectVO;
import com.sust.swy.crowd.entity.vo.PortalTypeVO;
import com.sust.swy.crowd.entity.vo.ProjectVO;
import com.sust.swy.crowd.entity.vo.TypeVO;

public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);

	List<PortalTypeVO> getPortalTypeVO();

	DetailProjectVO getDetailProjectVO(Integer projectId);

	List<PortalProjectVO> getDetailProjectVOByMemberId(Integer memberId);

	List<PortalProjectVO> getProjectVOByTypeId(Integer typeId, String keyword);

	List<TypeVO> getTypeVO();

	void removeProjectByProjectId(String projectId);

}
