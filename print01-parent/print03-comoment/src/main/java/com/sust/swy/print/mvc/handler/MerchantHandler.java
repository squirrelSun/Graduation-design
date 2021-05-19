package com.sust.swy.print.mvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sust.swy.print.service.api.MerchantService;

@Controller
public class MerchantHandler {

	@Autowired
	private MerchantService merchantService;
	
}
