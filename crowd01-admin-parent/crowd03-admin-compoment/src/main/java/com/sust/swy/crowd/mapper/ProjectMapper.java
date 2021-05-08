package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.Project;
import com.sust.swy.crowd.entity.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
	int countByExample(ProjectExample example);

	int deleteByExample(ProjectExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Project record);

	int insertSelective(Project record);

	List<Project> selectByExample(ProjectExample example);

	Project selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

	int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

	int updateByPrimaryKeySelective(Project record);

	int updateByPrimaryKey(Project record);

	List<Project> selectProjectByKeyword(String keyword);
}