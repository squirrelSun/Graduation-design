package com.sust.swy.print.service.impl;

import java.util.List;

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
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public PageInfo<OrderDetail> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrderDetail> list = orderMapper.selectOrderByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public List<Order> getOrderListByMemberId(Integer memberId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andMemberIdEqualTo(memberId);
		List<Order> list = orderMapper.selectByExample(example);
		return list;
	}
	
}
