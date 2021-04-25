package com.sust.swy.crowd.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sust.swy.crowd.entity.vo.ProjectVO;
import com.sust.swy.crowd.service.api.ProjectService;
import com.sust.swy.crowd.util.ResultEntity;

@RestController
public class ProjectProviderHandler {

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/save/project/vo/remote")
	public ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO,
			@RequestParam("memberId") Integer memberId) {
		try {
			projectService.saveProject(projectVO, memberId);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

}
