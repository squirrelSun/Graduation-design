package com.sust.swy.crowd.service.api;

import com.sust.swy.crowd.entity.vo.ProjectVO;

public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);

}
