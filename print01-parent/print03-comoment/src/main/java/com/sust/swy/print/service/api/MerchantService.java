package com.sust.swy.print.service.api;

import com.github.pagehelper.PageInfo;
import com.sust.swy.print.entity.Merchant;

public interface MerchantService {

	PageInfo<Merchant> getPageInfoForAdmin(String keyword, Integer pageNum, Integer pageSize);

	void changeMerchantById(Integer merchantId);

	void removeMerchantById(Integer merchantId);

	void saveMerchant(Merchant merchant);

	Merchant getMerchantByLoginAcct(String loginAcct, String usePswd);

}
