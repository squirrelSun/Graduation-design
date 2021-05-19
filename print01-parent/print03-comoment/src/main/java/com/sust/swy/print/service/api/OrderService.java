package com.sust.swy.print.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Order;
import com.sust.swy.print.entity.OrderDetail;

public interface OrderService {

	PageInfo<OrderDetail> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	List<Order> getOrderListByMemberId(Integer memberId);

}
