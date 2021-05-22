package com.sust.swy.print.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.OrderDetail;

public interface OrderService {

	PageInfo<OrderDetail> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	List<OrderDetail> getOrderListByMemberId(Integer memberId);

	void creatOrderForPay(Integer documentId, Integer memberId);

	void payOrderByOrderId(Integer orderId);

}
