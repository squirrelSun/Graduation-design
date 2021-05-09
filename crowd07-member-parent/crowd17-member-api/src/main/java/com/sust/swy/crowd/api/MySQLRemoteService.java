package com.sust.swy.crowd.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sust.swy.crowd.entity.po.MemberCerticficatInfoPO;
import com.sust.swy.crowd.entity.po.MemberPO;
import com.sust.swy.crowd.entity.vo.AddressVO;
import com.sust.swy.crowd.entity.vo.DetailProjectVO;
import com.sust.swy.crowd.entity.vo.OrderProjectLauchVO;
import com.sust.swy.crowd.entity.vo.OrderProjectVO;
import com.sust.swy.crowd.entity.vo.OrderVO;
import com.sust.swy.crowd.entity.vo.PortalProjectVO;
import com.sust.swy.crowd.entity.vo.PortalTypeVO;
import com.sust.swy.crowd.entity.vo.ProjectVO;
import com.sust.swy.crowd.entity.vo.TypeVO;
import com.sust.swy.crowd.util.ResultEntity;

@FeignClient("sust-swy-crowd-mysql")
public interface MySQLRemoteService {

	@RequestMapping("/get/memberpo/by/login/acct/remote")
	ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

	@RequestMapping("/save/memeber/remote")
	ResultEntity<String> saveMeneber(@RequestBody MemberPO memberPO);

	@RequestMapping("/save/project/vo/remote")
	ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO,
			@RequestParam("memberId") Integer memberId);

	@RequestMapping("/get/portal/type/project/data/remote")
	ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

	@RequestMapping("/get/project/detail/remote/{projectId}")
	ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

	@RequestMapping("/get/project/by/memberid")
	ResultEntity<List<PortalProjectVO>> getProjectByMemberId(@RequestParam("memberId") Integer memberId);

	@RequestMapping("/get/order/project/vo/remote")
	ResultEntity<OrderProjectVO> getOrderProjectVORemote(@RequestParam("projectId") Integer projectId,
			@RequestParam("returnId") Integer returnId);

	@RequestMapping("/get/address/vo/remote")
	ResultEntity<List<AddressVO>> getAddressVORemote(@RequestParam("memberId") Integer memberId);

	@RequestMapping("/save/address/remote")
	ResultEntity<String> saveAddressRemote(@RequestBody AddressVO addressVO);

	@RequestMapping("/save/order/remote")
	ResultEntity<String> saveOrderRemote(@RequestBody OrderVO orderVO);

	@RequestMapping("/get/memberpo/by/member/id")
	ResultEntity<MemberPO> getMemberPOByMemberid(@RequestParam("memberId") String memberId);

	@RequestMapping("/save/order/num/member/id")
	void addOrderWithPayOrderNum(@RequestParam("payOrderNum") String payOrderNum,
			@RequestParam("memberId") String memberId);

	@RequestMapping("/get/project/by/typd/id")
	ResultEntity<List<PortalProjectVO>> getProjectByTypeId(@RequestParam("typeId") Integer typeId,
			@RequestParam("keyword") String keyword);

	@RequestMapping("/get/type")
	ResultEntity<List<TypeVO>> getTypeVO();

	@RequestMapping("get/order/project/lauch/by/member/id")
	ResultEntity<List<OrderProjectLauchVO>> getOrderProjectLauchByMemberId(@RequestParam("memberId") Integer memberId);

	@RequestMapping("delete/project/detail/by/project/id")
	void deleteProjectDetailByProjectId(@RequestParam("projectId") String projectId);

	@RequestMapping("delete/order/detail/by/order/id")
	void deleteOrderDetailByOrderId(@RequestParam("orderId") String orderId);

	@RequestMapping("save/meneber/certicficat/info")
	void saveMeneberCerticficatInfo(@RequestBody MemberCerticficatInfoPO memberCerticficatInfoPO);

}
