package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.po.ProjectItemPicPO;
import com.sust.swy.crowd.entity.po.ProjectItemPicPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectItemPicPOMapper {
	int countByExample(ProjectItemPicPOExample example);

	int deleteByExample(ProjectItemPicPOExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ProjectItemPicPO record);

	int insertSelective(ProjectItemPicPO record);

	List<ProjectItemPicPO> selectByExample(ProjectItemPicPOExample example);

	ProjectItemPicPO selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") ProjectItemPicPO record,
			@Param("example") ProjectItemPicPOExample example);

	int updateByExample(@Param("record") ProjectItemPicPO record, @Param("example") ProjectItemPicPOExample example);

	int updateByPrimaryKeySelective(ProjectItemPicPO record);

	int updateByPrimaryKey(ProjectItemPicPO record);

	void insertPathList(@Param("projectId") Integer projectId,
			@Param("detailPicturePathList") List<String> detailPicturePathList);
}