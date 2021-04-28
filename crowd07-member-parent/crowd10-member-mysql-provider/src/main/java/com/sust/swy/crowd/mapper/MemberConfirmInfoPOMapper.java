package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.po.MemberConfirmInfoPO;
import com.sust.swy.crowd.entity.po.MemberConfirmInfoPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberConfirmInfoPOMapper {
	int countByExample(MemberConfirmInfoPOExample example);

	int deleteByExample(MemberConfirmInfoPOExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(MemberConfirmInfoPO record);

	int insertSelective(MemberConfirmInfoPO record);

	List<MemberConfirmInfoPO> selectByExample(MemberConfirmInfoPOExample example);

	MemberConfirmInfoPO selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") MemberConfirmInfoPO record,
			@Param("example") MemberConfirmInfoPOExample example);

	int updateByExample(@Param("record") MemberConfirmInfoPO record,
			@Param("example") MemberConfirmInfoPOExample example);

	int updateByPrimaryKeySelective(MemberConfirmInfoPO record);

	int updateByPrimaryKey(MemberConfirmInfoPO record);
}