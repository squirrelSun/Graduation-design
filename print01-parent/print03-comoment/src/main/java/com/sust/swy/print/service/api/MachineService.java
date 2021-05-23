package com.sust.swy.print.service.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.constant.util.ResultEntity;
import com.sust.swy.print.entity.Machine;
import com.sust.swy.print.entity.MachineWithMerchant;

public interface MachineService {

	PageInfo<MachineWithMerchant> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	void changeMachineById(Integer machineId);

	void removeMachineById(Integer machineId);

	List<Machine> getMachineListByMerchantId(Integer merchantId);

	ResultEntity<String> creatMachine(Integer merchantId, String machineName, String machineType);


}
