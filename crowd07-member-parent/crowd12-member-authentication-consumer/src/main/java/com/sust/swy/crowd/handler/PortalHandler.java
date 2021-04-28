package com.sust.swy.crowd.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sust.swy.crowd.api.MySQLRemoteService;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.vo.PortalTypeVO;
import com.sust.swy.crowd.util.ResultEntity;

@Controller
public class PortalHandler {

	@Autowired
	MySQLRemoteService mySQLRemoteService;
	
	@RequestMapping("/")
	public String showPortalPage(Model model) {
		ResultEntity<List<PortalTypeVO>> resultEntity = mySQLRemoteService.getPortalTypeProjectDataRemote();
		String result = resultEntity.getOperationResult();
		if (ResultEntity.SUCCESS.equals(result)) {
			List<PortalTypeVO> list = resultEntity.getQueryData();
			model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA , list);
		}
		return "portal";
	}

	
	
}
