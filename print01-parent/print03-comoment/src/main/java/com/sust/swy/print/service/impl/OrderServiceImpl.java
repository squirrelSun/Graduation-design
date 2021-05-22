package com.sust.swy.print.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Order;
import com.sust.swy.print.entity.OrderDetail;
import com.sust.swy.print.entity.OrderExample;
import com.sust.swy.print.entity.OrderExample.Criteria;
import com.sust.swy.print.mapper.OrderMapper;
import com.sust.swy.print.service.api.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public PageInfo<OrderDetail> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrderDetail> list = orderMapper.selectOrderByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public List<OrderDetail> getOrderListByMemberId(Integer memberId) {
		List<OrderDetail> list = orderMapper.selectOrderDetailByMemberId(memberId);
		return list;
	}

	@Override
	public void creatOrderForPay(Integer documentId, Integer memberId) {
		Order order = new Order();
		String uuid = UUID.randomUUID().toString();
		order.setMemberId(memberId);
		order.setDocumentId(documentId);
		order.setOrderNum(uuid);
		order.setOrderStatus(0);
		order.setOrderAmount(0.0);
		order.setOrderRemark("");
		orderMapper.insert(order);
	}

	@Override
	public void payOrderByOrderId(Integer orderId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		Order order = orderMapper.selectByExample(example).get(0);
		order.setOrderStatus(1);
		orderMapper.updateByPrimaryKeySelective(order);
	}

}
