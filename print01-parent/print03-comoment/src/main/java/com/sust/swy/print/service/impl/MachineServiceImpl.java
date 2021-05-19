package com.sust.swy.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Machine;
import com.sust.swy.print.entity.MachineWithMerchant;
import com.sust.swy.print.mapper.MachineMapper;
import com.sust.swy.print.service.api.MachineService;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private MachineMapper machineMapper;
	
	@Override
	public PageInfo<MachineWithMerchant> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<MachineWithMerchant> list = machineMapper.selectMachineByKeyword(keyword);
		return new PageInfo<>(list);
	}

	@Override
	public void changeMachineById(Integer machineId) {
		Machine machine = machineMapper.selectByPrimaryKey(machineId);
		if (machine.getMachineStatus() == 2) {
			machine.setMachineStatus(0);
		} else if (machine.getMachineStatus() == 0) {
			machine.setMachineStatus(2);
		}
		machineMapper.updateByPrimaryKey(machine);
	}

	@Override
	public void removeMachineById(Integer machineId) {
		Machine machine = machineMapper.selectByPrimaryKey(machineId);
		if (machine.getIsDelete() == 1) {
			machine.setIsDelete(0);
		} else if (machine.getIsDelete() == 0) {
			machine.setIsDelete(1);
		}
		machineMapper.updateByPrimaryKey(machine);
	}

}
