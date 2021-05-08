package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Member;
import com.sust.swy.crowd.entity.Project;
import com.sust.swy.crowd.mapper.MemberMapper;
import com.sust.swy.crowd.mapper.ProjectMapper;
import com.sust.swy.crowd.service.api.CheckService;

@Service
public class CheckServiceImpl implements CheckService{

	@Autowired
	private ProjectMapper projectMapper;
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public PageInfo<Project> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
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
