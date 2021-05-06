package com.sust.swy.crowd.service.impl;

import java.util.ArrayList;
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
import com.sust.swy.crowd.entity.po.ProjectPO;
import com.sust.swy.crowd.entity.po.ProjectPOExample;
import com.sust.swy.crowd.entity.vo.AddressVO;
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
		orderProjectPOMapper.insert(orderProjectPO);
		String projectName = orderProjectPO.getProjectName();
		ProjectPOExample example = new ProjectPOExample();
		example.createCriteria().andProjectNameEqualTo(projectName);
		ProjectPO projectPO = projectPOMapper.selectByExample(example).get(0);
		projectPO.setSupportmoney((long)(projectPO.getSupportmoney() + orderVO.getOrderAmount()));
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

}
