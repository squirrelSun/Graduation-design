package com.sust.swy.print.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sust.swy.print.entity.Order;
import com.sust.swy.print.entity.OrderDetail;
import com.sust.swy.print.entity.OrderExample;

public interface OrderMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int countByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int deleteByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int insert(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int insertSelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	List<Order> selectByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	Order selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int updateByPrimaryKeySelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table t_order
	 *
	 * @mbggenerated Tue May 18 09:20:06 CST 2021
	 */
	int updateByPrimaryKey(Order record);

	List<OrderDetail> selectOrderByKeyword(@Param("keyword") String keyword);

	List<OrderDetail> selectOrderDetailByMemberId(@Param("memberId") Integer memberId);

	List<OrderDetail> selectOrderDetailByMerchantId(@Param("merchantId") Integer merchantId);

	List<OrderDetail> selectOrderListWithOutChack();
}