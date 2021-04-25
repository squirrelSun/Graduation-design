package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.po.ProjectPO;
import com.sust.swy.crowd.entity.po.ProjectPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPOMapper {
    int countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

	void insertTypeRelationship(List<Integer> typeIdList, Integer projectId);

	void insertTagRelationship(List<Integer> tagIdList, Integer projectId);
}