package com.sust.swy.crowd.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sust.swy.crowd.api.MySQLRemoteService;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.vo.AddressVO;
import com.sust.swy.crowd.entity.vo.MemberLoginVO;
import com.sust.swy.crowd.entity.vo.OrderProjectVO;
import com.sust.swy.crowd.util.ResultEntity;

@Controller
public class OrderHandler {

	@Autowired
	private MySQLRemoteService mySQLRemoteService;

	private Logger logger = LoggerFactory.getLogger(OrderHandler.class);

	@RequestMapping("/success/{payOrderNum}")
	public String paySuccess(@PathVariable("payOrderNum") String payOrderNum, HttpSession session) {
		MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
		Integer memberId = memberLoginVO.getId();
		mySQLRemoteService.addOrderWithPayOrderNum(payOrderNum, String.valueOf(memberId));
		return "pay-success";
	}

	@RequestMapping("/save/address")
	public String saveAddress(AddressVO addressVO, HttpSession session) {
		ResultEntity<String> resultEntity = mySQLRemoteService.saveAddressRemote(addressVO);
		logger.debug("地址保存处理结果：" + resultEntity.getOperationResult());
		OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
		Integer returnCount = orderProjectVO.getReturnCount();
		return "redirect:http://localhost/order/confirm/order/" + returnCount;
	}

	@RequestMapping("/confirm/order/{returnCount}")
	public String showConfirmOrderInfo(@PathVariable("returnCount") Integer returnCount, HttpSession session) {
		MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
		Integer memberId = memberLoginVO.getId();
		OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
		orderProjectVO.setReturnCount(returnCount);
		session.setAttribute("orderProjectVO", orderProjectVO);
		ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVORemote(memberId);
		if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())) {
			List<AddressVO> list = resultEntity.getQueryData();
			session.setAttribute("addressVOList", list);
		}
		return "confirm_order";
	}

	@RequestMapping("/confirm/return/info/{projectId}/{returnId}")
	public String showReturnConfirmInfo(@PathVariable("projectId") Integer projectId,
			@PathVariable("returnId") Integer returnId, HttpSession session) {
		ResultEntity<OrderProjectVO> resultEntity = mySQLRemoteService.getOrderProjectVORemote(projectId, returnId);
		if (ResultEntity.SUCCESS.equals(resultEntity.getOperationResult())) {
			OrderProjectVO orderProjectVO = resultEntity.getQueryData();
			session.setAttribute("orderProjectVO", orderProjectVO);
		}
		return "confirm_return";
	}

}
