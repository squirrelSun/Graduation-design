package com.sust.swy.print.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.exception.LoginFailedException;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.entity.Machine;
import com.sust.swy.print.entity.MachineExample;
import com.sust.swy.print.entity.MachineExample.Criteria;
import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.entity.MerchantExample;
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

	@Override
	public void saveMerchant(Merchant merchant) {
		merchantMapper.insertSelective(merchant);		
	}

	@Override
	public Merchant getMerchantByLoginAcct(String loginAcct, String usePswd) {
		MerchantExample merchantExample = new MerchantExample();
		com.sust.swy.print.entity.MerchantExample.Criteria criteria = merchantExample.createCriteria();
		criteria.andLoginAcctEqualTo(loginAcct);
		List<Merchant> list = merchantMapper.selectByExample(merchantExample);
		if (list == null || list.size() == 0) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		if (list.size() > 1) {
			throw new RuntimeException(PrintConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
		}
		Merchant merchant = list.get(0);
		if (merchant == null) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		String userPswdDB = merchant.getLoginPswd();
		String userPaedFrom = PrintUtil.md5(usePswd);
		if (!Objects.equals(userPswdDB, userPaedFrom)) {
			throw new LoginFailedException(PrintConstant.MESSAGE_LOGIN_FAILED);
		}
		return merchant;
	}

}
