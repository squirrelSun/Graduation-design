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
import com.sust.swy.print.mapper.MemberMapper;
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
		order.setIsDelete(0);
		orderMapper.insert(order);
	}

	@Override
	public void payOrderByOrderId(Integer orderId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		Order order = orderMapper.selectByExample(example).get(0);
		order.setOrderStatus(1);
		UUID uuid = UUID.randomUUID();
		order.setPayOrderNum(uuid.toString());
		orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public List<OrderDetail> getOrderListByMerchantId(Integer merchantId) {
		List<OrderDetail> list = orderMapper.selectOrderDetailByMerchantId(merchantId);
		return list;
	}

	@Override
	public Order getOrderByOrderId(Integer orderId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(orderId);
		List<Order> list = orderMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<OrderDetail> getOrderListWithOutChack() {
		List<OrderDetail> list = orderMapper.selectOrderListWithOutChack();
		return list;
	}

	@Override
	public void chooseOrder(Integer merchantId, String machineId, String orderId, String orderPay, String orderWrite) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(Integer.valueOf(orderId));
		List<Order> list = orderMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return;
		}
		Order order = list.get(0);
		order.setMachineId(Integer.valueOf(machineId));
		order.setMerchantId(merchantId);
		order.setOrderAmount(Double.valueOf(orderPay));
		order.setOrderRemark(orderWrite);
		orderMapper.updateByPrimaryKey(order);
	}

}
