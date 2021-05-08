package com.sust.swy.crowd.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.vo.AddressVO;
import com.sust.swy.crowd.entity.vo.OrderProjectLauchVO;
import com.sust.swy.crowd.entity.vo.OrderProjectVO;
import com.sust.swy.crowd.entity.vo.OrderVO;
import com.sust.swy.crowd.service.api.OrderService;
import com.sust.swy.crowd.util.ResultEntity;

@RestController
public class OrderProviderHandler {

	@Autowired
	private OrderService orderService;

	@RequestMapping("delete/order/detail/by/order/id")
	public void deleteOrderDetailByOrderId(@RequestParam("orderId") String orderId) {
		orderService.removeOrderDetailByOrderId(orderId);
	}

	@RequestMapping("/get/order/project/lauch/by/member/id")
	ResultEntity<List<OrderProjectLauchVO>> getOrderProjectLauchByMemberId(@RequestParam("memberId") Integer memberId) {
		try {
			List<OrderProjectLauchVO> orderProjectLauchVOList = orderService
					.getOrderProjectLauchListByMemberId(memberId);
			return ResultEntity.successWithData(orderProjectLauchVOList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/save/order/num/member/id")
	void addOrderWithPayOrderNum(@RequestParam("payOrderNum") String payOrderNum,
			@RequestParam("memberId") String memberId) {
		orderService.updateOrderWithPayOrderNum(payOrderNum, memberId);
	}

	@RequestMapping("/save/order/remote")
	ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO) {
		try {
			orderService.saveOrder(orderVO);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/save/address/remote")
	public ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO) {
		try {
			orderService.saveAddress(addressVO);
			return ResultEntity.successWithoutData();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/get/address/vo/remote")
	ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId) {
		try {
			List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
			return ResultEntity.successWithData(addressVOList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

	@RequestMapping("/get/order/project/vo/remote")
	ResultEntity<OrderProjectVO> getOrderProjectVORemote(@RequestParam("projectId") Integer projectId,
			@RequestParam("returnId") Integer returnId) {
		try {
			OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(projectId, returnId);
			return ResultEntity.successWithData(orderProjectVO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultEntity.failed(e.getMessage());
		}
	}

}
