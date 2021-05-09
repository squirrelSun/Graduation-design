package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.po.MemberCerticficatInfoPO;
import com.sust.swy.crowd.entity.po.MemberCerticficatInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCerticficatInfoPOMapper {
    int countByExample(MemberCerticficatInfoPOExample example);

    int deleteByExample(MemberCerticficatInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberCerticficatInfoPO record);

    int insertSelective(MemberCerticficatInfoPO record);

    List<MemberCerticficatInfoPO> selectByExample(MemberCerticficatInfoPOExample example);

    MemberCerticficatInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberCerticficatInfoPO record, @Param("example") MemberCerticficatInfoPOExample example);

    int updateByExample(@Param("record") MemberCerticficatInfoPO record, @Param("example") MemberCerticficatInfoPOExample example);

    int updateByPrimaryKeySelective(MemberCerticficatInfoPO record);

    int updateByPrimaryKey(MemberCerticficatInfoPO record);
}