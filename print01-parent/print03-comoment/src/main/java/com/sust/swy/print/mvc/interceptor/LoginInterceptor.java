package com.sust.swy.print.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sust.swy.print.constant.PrintConstant;
import com.sust.swy.print.constant.exception.AccessForbiddenException;
import com.sust.swy.print.entity.Admin;
import com.sust.swy.print.entity.Member;
import com.sust.swy.print.entity.Merchant;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute(PrintConstant.ATTR_NAME_ADMIN);
		Member member = (Member) session.getAttribute(PrintConstant.ATTR_NAME_ADMIN);
		Merchant merchant = (Merchant) session.getAttribute(PrintConstant.ATTR_NAME_ADMIN);
		if (admin == null && member == null && merchant == null) {
			throw new AccessForbiddenException(PrintConstant.MESSAGE_ACCESS_FORBIDEN);
		}
		return true;
	}
}
