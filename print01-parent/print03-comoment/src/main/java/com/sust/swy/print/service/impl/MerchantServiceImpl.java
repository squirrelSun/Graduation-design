package com.sust.swy.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Machine;
import com.sust.swy.print.entity.MachineExample;
import com.sust.swy.print.entity.MachineExample.Criteria;
import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.mapper.MachineMapper;
import com.sust.swy.print.mapper.MerchantMapper;
import com.sust.swy.print.service.api.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantMapper merchantMapper;

	@Autowired
	private MachineMapper machineMapper;

	@Override
	public PageInfo<Merchant> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Merchant> list = merchantMapper.selectMerchantByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public void changeMerchantById(Integer merchantId) {
		Merchant merchant = merchantMapper.selectByPrimaryKey(merchantId);
		if (merchant.getMerchantStatus() == 0) {
			merchant.setMerchantStatus(1);
		} else if (merchant.getMerchantStatus() == 1) {
			merchant.setMerchantStatus(2);
		} else if (merchant.getMerchantStatus() == 2) {
			merchant.setMerchantStatus(1);
		}
		merchantMapper.updateByPrimaryKey(merchant);
	}

	@Override
	public void removeMerchantById(Integer merchantId) {
		Merchant merchant = merchantMapper.selectByPrimaryKey(merchantId);
		if (merchant.getIsDelete() == 1) {
			merchant.setIsDelete(0);
			MachineExample example = new MachineExample();
			Criteria criteria = example.createCriteria();
			criteria.andMerchantIdEqualTo(merchantId);
			List<Machine> list = machineMapper.selectByExample(example);
			for (Machine machine : list) {
				machine.setIsDelete(0);
				machineMapper.updateByPrimaryKey(machine);
			}
		} else if (merchant.getIsDelete() == 0) {
			merchant.setIsDelete(1);
			MachineExample example = new MachineExample();
			Criteria criteria = example.createCriteria();
			criteria.andMerchantIdEqualTo(merchantId);
			List<Machine> list = machineMapper.selectByExample(example);
			for (Machine machine : list) {
				machine.setIsDelete(1);
				machineMapper.updateByPrimaryKey(machine);
			}
		}
		merchantMapper.updateByPrimaryKey(merchant);
	}

}
