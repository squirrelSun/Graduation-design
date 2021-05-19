package com.sust.swy.print.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.MachineWithMerchant;

public interface MachineService {

	PageInfo<MachineWithMerchant> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	void changeMachineById(Integer machineId);

	void removeMachineById(Integer machineId);


}
