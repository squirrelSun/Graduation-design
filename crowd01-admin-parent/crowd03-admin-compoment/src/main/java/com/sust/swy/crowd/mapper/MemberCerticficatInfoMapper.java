package com.sust.swy.crowd.mapper;

import com.sust.swy.crowd.entity.MemberCerticficatInfo;
import com.sust.swy.crowd.entity.MemberCerticficatInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCerticficatInfoMapper {
    int countByExample(MemberCerticficatInfoExample example);

    int deleteByExample(MemberCerticficatInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberCerticficatInfo record);

    int insertSelective(MemberCerticficatInfo record);

    List<MemberCerticficatInfo> selectByExample(MemberCerticficatInfoExample example);

    MemberCerticficatInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberCerticficatInfo record, @Param("example") MemberCerticficatInfoExample example);

    int updateByExample(@Param("record") MemberCerticficatInfo record, @Param("example") MemberCerticficatInfoExample example);

    int updateByPrimaryKeySelective(MemberCerticficatInfo record);

    int updateByPrimaryKey(MemberCerticficatInfo record);

	List<MemberCerticficatInfo> selectMemberCerticficatInfoByKeyword(String keyword);
}