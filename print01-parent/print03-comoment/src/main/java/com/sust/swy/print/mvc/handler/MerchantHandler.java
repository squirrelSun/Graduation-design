package com.sust.swy.print.mvc.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.util.PrintUtil;
import com.sust.swy.print.constant.util.ResultEntity;
import com.sust.swy.print.entity.Machine;
import com.sust.swy.print.entity.Merchant;
import com.sust.swy.print.entity.Order;
import com.sust.swy.print.entity.OrderDetail;
import com.sust.swy.print.service.api.DocumentService;
import com.sust.swy.print.service.api.MachineService;
import com.sust.swy.print.service.api.MerchantService;
import com.sust.swy.print.service.api.OrderService;

@Controller
public class MerchantHandler {

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private MachineService machineService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private DocumentService documentService;

	@RequestMapping("/merchant/check/order/{orderId}/{machineId}.html")
	public String machineChooseOrderSuccess(@PathVariable("orderId") String orderId,
			@PathVariable("machineId") String machineId, @RequestParam("orderPay") String orderPay,
			@RequestParam("orderWrite") String orderWrite, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute(PrintConstant.ATTR_NAME_MERCHANT);
		Integer merchantId = merchant.getId();
		orderService.chooseOrder(merchantId, machineId, orderId, orderPay, orderWrite);
		List<Machine> machineList = machineService.getMachineListByMerchantId(merchantId);
		List<OrderDetail> orderlist = orderService.getOrderListByMerchantId(merchantId);
		session.setAttribute(PrintConstant.ATTR_NAME_MACHINE, machineList);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/merchant/main/page.html";
	}

	@RequestMapping("/order/check/{machineId}.html")
	public String machineChooseOrder(@PathVariable("machineId") String machineId, HttpSession session) {
		List<OrderDetail> orderlist = orderService.getOrderListWithOutChack();
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		session.setAttribute("machineId", machineId);
		return "redirect:/to/merchant/check/page.html";
	}

	@ResponseBody
	@RequestMapping("/machine/save.json")
	public ResultEntity<String> creatMachine(@RequestParam("machineName") String machineName,
			@RequestParam("machineType") String machineType, HttpSession session) throws IOException {
		Merchant merchant = (Merchant) session.getAttribute(PrintConstant.ATTR_NAME_MERCHANT);
		Integer merchantId = merchant.getId();
		ResultEntity<String> creatMachineResultEntity = machineService.creatMachine(merchantId, machineName,
				machineType);
		List<Machine> machineList = machineService.getMachineListByMerchantId(merchantId);
		List<OrderDetail> orderlist = orderService.getOrderListByMerchantId(merchantId);
		session.setAttribute(PrintConstant.ATTR_NAME_MACHINE, machineList);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return creatMachineResultEntity;
	}

	@RequestMapping("/machine/print/{orderId}.html")
	public String machinePrint(@PathVariable("orderId") String orderId, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute(PrintConstant.ATTR_NAME_MERCHANT);
		Integer merchantId = merchant.getId();
		Order order = orderService.getOrderByOrderId(Integer.valueOf(orderId));
		Integer documentId = order.getDocumentId();
		documentService.changeDocumentByID(documentId);
		List<Machine> machineList = machineService.getMachineListByMerchantId(merchantId);
		List<OrderDetail> orderlist = orderService.getOrderListByMerchantId(merchantId);
		session.setAttribute(PrintConstant.ATTR_NAME_MACHINE, machineList);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/merchant/main/page.html";
	}

	@RequestMapping("/machine/remove/{machineId}.html")
	public String machineRemove(@PathVariable("machineId") String machineId, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute(PrintConstant.ATTR_NAME_MERCHANT);
		Integer merchantId = merchant.getId();
		machineService.removeMachineById(Integer.valueOf(machineId));
		List<Machine> machineList = machineService.getMachineListByMerchantId(merchantId);
		List<OrderDetail> orderlist = orderService.getOrderListByMerchantId(merchantId);
		session.setAttribute(PrintConstant.ATTR_NAME_MACHINE, machineList);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		return "redirect:/to/merchant/main/page.html";
	}

	@RequestMapping("/merchant/do/register.html")
	public String merchantDoRegister(@RequestParam("loginAcct") String loginAcct,
			@RequestParam("userpswd") String userpswd, @RequestParam("username") String username,
			@RequestParam("email") String email, @RequestParam("accountNum") String accountNum, HttpSession session) {
		String coding = PrintUtil.md5(userpswd);
		Merchant merchant = new Merchant();
		merchant.setLoginAcct(loginAcct);
		merchant.setLoginPswd(coding);
		merchant.setMerchantName(username);
		merchant.setMerchantEmail(email);
		merchant.setAccountNum(accountNum);
		merchantService.saveMerchant(merchant);
		session.setAttribute(PrintConstant.ATTR_NAME_MERCHANT, merchant);
		return "redirect:/to/merchant/login/page.html";
	}

	@RequestMapping("/merchant/loginout.html")
	public String merchantLoginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/to/merchant/login/page.html";
	}

	@RequestMapping("/merchant/do/login.html")
	public String merchantDoLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("usePswd") String usePswd,
			HttpSession session) {
		Merchant merchant = merchantService.getMerchantByLoginAcct(loginAcct, usePswd);
		Integer merchantId = merchant.getId();
		List<Machine> machineList = machineService.getMachineListByMerchantId(merchantId);
		List<OrderDetail> orderlist = orderService.getOrderListByMerchantId(merchantId);
		session.setAttribute(PrintConstant.ATTR_NAME_MACHINE, machineList);
		session.setAttribute(PrintConstant.ATTR_NAME_ORDER, orderlist);
		session.setAttribute(PrintConstant.ATTR_NAME_MERCHANT, merchant);
		return "redirect:/to/merchant/main/page.html";
	}

}
