package com.sust.swy.print.mapper;

import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.entity.MerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int countByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int deleteByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int insert(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int insertSelective(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    List<Merchant> selectByExample(MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    Merchant selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int updateByExampleSelective(@Param("record") Merchant record, @Param("example") MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int updateByExample(@Param("record") Merchant record, @Param("example") MerchantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int updateByPrimaryKeySelective(Merchant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_merchant
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    int updateByPrimaryKey(Merchant record);

	List<Merchant> selectMerchantByKeyword(@Param("keyword") String keyword);
}