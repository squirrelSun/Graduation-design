package com.sust.swy.crowd.service.api;

import java.util.List;

import com.sust.swy.crowd.entity.vo.AddressVO;
import com.sust.swy.crowd.entity.vo.OrderProjectLauchVO;
import com.sust.swy.crowd.entity.vo.OrderProjectVO;
import com.sust.swy.crowd.entity.vo.OrderVO;

public interface OrderService {

	OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

	List<AddressVO> getAddressVOList(Integer memberId);

	void saveAddress(AddressVO addressVO);

	void saveOrder(OrderVO orderVO);

	void updateOrderWithPayOrderNum(String payOrderNum, String memberId);

	List<OrderProjectLauchVO> getOrderProjectLauchListByMemberId(Integer memberId);

	void removeOrderDetailByOrderId(String orderId);

}
