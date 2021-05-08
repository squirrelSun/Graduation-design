package com.sust.swy.crowd.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.crowd.entity.Project;

public interface CheckService {

	PageInfo<Project> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

	void removeProjectById(Integer projectId);

	void agreeProjectById(Integer projectId);

	void successProjectById(Integer projectId);

	void failProjectById(Integer projectId);

}
