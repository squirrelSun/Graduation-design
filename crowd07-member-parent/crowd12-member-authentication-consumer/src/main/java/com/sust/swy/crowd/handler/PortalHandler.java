package com.sust.swy.crowd.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sust.swy.crowd.api.MySQLRemoteService;
import com.sust.swy.crowd.constant.CrowdConstant;
import com.sust.swy.crowd.entity.vo.PortalProjectVO;
import com.sust.swy.crowd.entity.vo.PortalTypeVO;
import com.sust.swy.crowd.entity.vo.TypeVO;
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
			model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
		}
		return "portal";
	}

	@RequestMapping(value = { "/more/{typeId}", "/more/{typeId}/{keyword}" })
	public String showPortalMore(Model model, @PathVariable("typeId") Integer typeId,
			@PathVariable(value = "keyword", required = false) String keyword) {
		if (keyword == null)
			keyword = "";
		ResultEntity<List<TypeVO>> resultEntityType = mySQLRemoteService.getTypeVO();
		String resultType = resultEntityType.getOperationResult();
		if (ResultEntity.SUCCESS.equals(resultType)) {
			List<TypeVO> list = resultEntityType.getQueryData();
			model.addAttribute(CrowdConstant.ATTR_NAME_TYPE, list);
		}
		ResultEntity<List<PortalProjectVO>> resultEntity = mySQLRemoteService.getProjectByTypeId(typeId, keyword);
		String result = resultEntity.getOperationResult();
		if (ResultEntity.SUCCESS.equals(result)) {
			List<PortalProjectVO> list = resultEntity.getQueryData();
			model.addAttribute(CrowdConstant.ATTR_NAME_PORTAL_DATA, list);
		}
		return "portal-more";
	}

}
