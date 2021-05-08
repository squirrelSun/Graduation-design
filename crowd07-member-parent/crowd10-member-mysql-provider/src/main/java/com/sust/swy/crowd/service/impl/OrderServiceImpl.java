package com.sust.swy.crowd.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sust.swy.crowd.entity.po.AddressPO;
import com.sust.swy.crowd.entity.po.AddressPOExample;
import com.sust.swy.crowd.entity.po.OrderPO;
import com.sust.swy.crowd.entity.po.OrderPOExample;
import com.sust.swy.crowd.entity.po.OrderProjectPO;
import com.sust.swy.crowd.entity.po.OrderProjectPOExample;
import com.sust.swy.crowd.entity.po.ProjectPO;
import com.sust.swy.crowd.entity.po.ProjectPOExample;
import com.sust.swy.crowd.entity.vo.AddressVO;
import com.sust.swy.crowd.entity.vo.OrderProjectLauchVO;
import com.sust.swy.crowd.entity.vo.OrderProjectVO;
import com.sust.swy.crowd.entity.vo.OrderVO;
import com.sust.swy.crowd.mapper.AddressPOMapper;
import com.sust.swy.crowd.mapper.OrderPOMapper;
import com.sust.swy.crowd.mapper.OrderProjectPOMapper;
import com.sust.swy.crowd.mapper.ProjectPOMapper;
import com.sust.swy.crowd.service.api.OrderService;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderProjectPOMapper orderProjectPOMapper;

	@Autowired
	private OrderPOMapper orderPOMapper;

	@Autowired
	private AddressPOMapper addressPOMapper;

	@Autowired
	private ProjectPOMapper projectPOMapper;

	@Override
	public OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId) {
		return orderProjectPOMapper.selectOrderProjectVO(returnId);
	}

	@Override
	public List<AddressVO> getAddressVOList(Integer memberId) {
		AddressPOExample example = new AddressPOExample();
		example.createCriteria().andMemberIdEqualTo(memberId);
		List<AddressPO> addressPOList = addressPOMapper.selectByExample(example);
		List<AddressVO> addressVOList = new ArrayList<AddressVO>();
		for (AddressPO addressPO : addressPOList) {
			AddressVO addressVO = new AddressVO();
			BeanUtils.copyProperties(addressPO, addressVO);
			addressVOList.add(addressVO);
		}
		return addressVOList;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void saveAddress(AddressVO addressVO) {
		AddressPO addressPO = new AddressPO();
		BeanUtils.copyProperties(addressVO, addressPO);
		addressPOMapper.insert(addressPO);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void saveOrder(OrderVO orderVO) {
		OrderPO orderPO = new OrderPO();
		BeanUtils.copyProperties(orderVO, orderPO);
		OrderProjectPO orderProjectPO = new OrderProjectPO();
		BeanUtils.copyProperties(orderVO.getOrderProjectVO(), orderProjectPO);
		orderPOMapper.insert(orderPO);
		Integer id = orderPO.getId();
		orderProjectPO.setOrderId(id);
		orderProjectPO.setProjectId(orderProjectPO.getId());
		orderProjectPO.setId(null);
		orderProjectPOMapper.insert(orderProjectPO);
		String projectName = orderProjectPO.getProjectName();
		ProjectPOExample example = new ProjectPOExample();
		example.createCriteria().andProjectNameEqualTo(projectName);
		ProjectPO projectPO = projectPOMapper.selectByExample(example).get(0);
		projectPO.setSupportmoney((long) (projectPO.getSupportmoney() + orderVO.getOrderAmount()));
		projectPOMapper.updateByPrimaryKey(projectPO);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void updateOrderWithPayOrderNum(String payOrderNum, String memberId) {
		OrderPOExample example = new OrderPOExample();
		example.createCriteria().andPayOrderNumEqualTo(payOrderNum);
		List<OrderPO> orderPOList = orderPOMapper.selectByExample(example);
		OrderPO orderPO = orderPOList.get(0);
		orderPO.setMemberId(memberId);
		orderPOMapper.updateByPrimaryKey(orderPO);
	}

	@Override
	public List<OrderProjectLauchVO> getOrderProjectLauchListByMemberId(Integer memberId) {
		OrderPOExample orderPOExample = new OrderPOExample();
		orderPOExample.createCriteria().andMemberIdEqualTo(String.valueOf(memberId));
		List<OrderPO> orderPOList = orderPOMapper.selectByExample(orderPOExample);
		List<OrderProjectLauchVO> returnList = new ArrayList<>();
		for (OrderPO orderPO : orderPOList) {
			OrderProjectLauchVO orderProjectLauchVO = new OrderProjectLauchVO();
			Integer orderId = orderPO.getId();
			OrderProjectPOExample orderProjectPOExample = new OrderProjectPOExample();
			orderProjectPOExample.createCriteria().andOrderIdEqualTo(orderId);
			OrderProjectPO orderProjectPO = orderProjectPOMapper.selectByExample(orderProjectPOExample).get(0);
			Integer projectId = orderProjectPO.getProjectId();
			ProjectPOExample projectPOExample = new ProjectPOExample();
			projectPOExample.createCriteria().andIdEqualTo(projectId);
			ProjectPO projectPO = projectPOMapper.selectByExample(projectPOExample).get(0);
			String addressId = orderPO.getAddressId();
			AddressPOExample addressPOExample = new AddressPOExample();
			addressPOExample.createCriteria().andIdEqualTo(Integer.valueOf(addressId));
			AddressPO addressPO = addressPOMapper.selectByExample(addressPOExample).get(0);
			orderProjectLauchVO.setOrderId(orderId);
			orderProjectLauchVO.setProjectId(projectId);
			orderProjectLauchVO.setProjectName(projectPO.getProjectName());
			orderProjectLauchVO.setProjectDescription(projectPO.getProjectDescription());
			DecimalFormat df = new DecimalFormat("0.00");
			orderProjectLauchVO.setPercentage(df
					.format(Double.valueOf(String.valueOf(projectPO.getSupportmoney())) / projectPO.getMoney() * 100));
			orderProjectLauchVO.setDay(projectPO.getDay());
			orderProjectLauchVO.setStatus(projectPO.getStatus());
			orderProjectLauchVO.setDeploydate(projectPO.getDeploydate());
			String deployDate = projectPO.getDeploydate();
			Date currentDay = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date deployDay = format.parse(deployDate);
				long currentTimeStamp = currentDay.getTime();
				long deployTimeStamp = deployDay.getTime();
				long pastDays = (currentTimeStamp - deployTimeStamp) / 1000 / 60 / 60 / 24;
				Integer totalDays = projectPO.getDay();
				Integer lastDay = (int) (totalDays - pastDays);
				orderProjectLauchVO.setLastday(lastDay);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			orderProjectLauchVO.setFreight(orderProjectPO.getFreight());
			orderProjectLauchVO.setOrderNum(orderPO.getOrderNum());
			orderProjectLauchVO.setPayOrderNum(orderPO.getPayOrderNum());
			orderProjectLauchVO.setOrderAmount(orderPO.getOrderAmount());
			orderProjectLauchVO.setInvoiceTitle(orderPO.getInvoiceTitle());
			orderProjectLauchVO.setOrderRemark(orderPO.getOrderRemark());
			orderProjectLauchVO.setReceiveName(addressPO.getReceiveName());
			orderProjectLauchVO.setPhoneNum(addressPO.getPhoneNum());
			orderProjectLauchVO.setAddress(addressPO.getAddress());
			returnList.add(orderProjectLauchVO);
		}
		Collections.reverse(returnList);
		return returnList;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void removeOrderDetailByOrderId(String orderId) {
		orderPOMapper.deleteByPrimaryKey(Integer.valueOf(orderId));
	}

}
